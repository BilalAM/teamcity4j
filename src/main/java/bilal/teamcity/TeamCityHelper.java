package bilal.teamcity;

import bilal.teamcity4j.core.*;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class TeamCityHelper {

        private static final String PROJECTS = "http://localhost:8111/app/rest/projects/";
        private static String SINGLE_PROJECT = "http://localhost:8111/app/rest/projects/id:%s";
        private static String BUILDTYPE_HISTORY_OF_BUILDTYPE = "http://localhost:8111/app/rest/buildTypes/%s/builds";

        private static SAXReader xmlReader = new SAXReader();
        private static TeamCityParser parser = new TeamCityParser();

        /**
         * Returns a list of all projects made in Teamcity .
         *
         * @return : List of Node objects of all projects
         */
        public static List<TeamCityProject> getAllProjects() {
                List<TeamCityProject> allProjects = new ArrayList<TeamCityProject>();

                List<Node> allProjectsNodes;
                try {
                        String allProjectsResponse = (String) TeamCityRestUtils.get(PROJECTS, String.class);
                        Document allProjectsDocument = xmlReader.read(new StringReader(allProjectsResponse));
                        allProjectsNodes = allProjectsDocument.selectNodes("/projects/project");
                        for (Node projectNode : allProjectsNodes) {
                                TeamCityProject teamCityProject = parser.getSingleProjectFromSingleNode(projectNode);
                                allProjects.add(teamCityProject);
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return allProjects;
        }

        /**
         * Returns a single TeamCity Project by the specified project id .
         *
         * @param projectID : The project id of the teamcity project .
         * @return : A complete TeamCity Project with all the builds and build history .
         */
        public static TeamCityProject getProject(String projectID) {
                TeamCityProject project = new TeamCityProject();

                String singleProjectUrl = String.format(SINGLE_PROJECT, projectID);
                String singleProjectResponse;

                Document singleProjectDocument;

                Node singleProjectNode;
                List<TeamCityProjectBuildType> teamCityProjectbuildTypes = new ArrayList<TeamCityProjectBuildType>();
                try {
                        singleProjectResponse = (String) TeamCityRestUtils.get(singleProjectUrl, String.class);
                        singleProjectDocument = xmlReader.read(new StringReader(singleProjectResponse));
                        singleProjectNode = singleProjectDocument.selectSingleNode("/project");
                        project = parser.getSingleProjectFromSingleNode(singleProjectNode);
                        for (TeamCityProjectBuildType buildType : getAllbuildTypes(projectID)) {
                                teamCityProjectbuildTypes.add(buildType);
                        }
                        project.setProjectbuildTypes(teamCityProjectbuildTypes);
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return project;
        }

        /**
         * Returns a list of all build types of a particular project
         *
         * @param projectID : The project id of the url
         * @return : List of Node objects that consists of all the build steps of a project.
         */
        public static List<TeamCityProjectBuildType> getAllbuildTypes(String projectID) {
                List<TeamCityProjectBuildType> buildTypes = new ArrayList<TeamCityProjectBuildType>();
                List<Node> allBuildTypesNodes;

                String buildTypesUrl = String.format(SINGLE_PROJECT, projectID);
                String buildTypesResponse;

                Document buildTypesDocument;
                try {
                        buildTypesResponse = (String) TeamCityRestUtils.get(buildTypesUrl, String.class);
                        buildTypesDocument = xmlReader.read(new StringReader(buildTypesResponse));
                        allBuildTypesNodes = buildTypesDocument.selectNodes("/project/buildTypes/buildType");

                        for (Node buildTypeNode : allBuildTypesNodes) {
                                TeamCityProjectBuildType buildType = parser.parsebuildTypeNode(buildTypeNode);
                                List<TeamCityBuild> buildHistory = getBuildHistoryOfBuildType(
                                        buildType.getBuildTypeID());
                                buildType.setBuildHistory(buildHistory);
                                buildTypes.add(buildType);
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return buildTypes;
        }

        /**
         * Returns a list of all the build history of a particular build type .
         *
         * @param buildTypeId : The build type id of that project .
         * @return : A list of build history .
         */
        public static List<TeamCityBuild> getBuildHistoryOfBuildType(String buildTypeId) {
                List<TeamCityBuild> buildHistory = new ArrayList<TeamCityBuild>();
                List<Node> buildHistoryNodes;
                String buildHistoryUrl = String.format(BUILDTYPE_HISTORY_OF_BUILDTYPE, buildTypeId);
                String buildHistoryResponse;
                Document buildHistoryDocument;
                try {
                        buildHistoryResponse = (String) TeamCityRestUtils.get(buildHistoryUrl, String.class);
                        buildHistoryDocument = xmlReader.read(new StringReader(buildHistoryResponse));
                        buildHistoryNodes = buildHistoryDocument.selectNodes("/builds/build");
                        for (Node buildHistoryNode : buildHistoryNodes) {
                                TeamCityBuild build = parser.parseBuildHistoryNode(buildHistoryNode);
                                buildHistory.add(build);
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return buildHistory;
        }

}
