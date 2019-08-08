/**
 * MIT License
 * <p>
 * Copyright (c) 2019 Bilal Asif Mirza
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package bilal.teamcity4j;

import bilal.teamcity4j.client.TeamCityRestUtils;
import bilal.teamcity4j.core.TeamCityParser;
import bilal.teamcity4j.core.TeamCityProject;
import bilal.teamcity4j.core.TeamCityProjectBuild;
import bilal.teamcity4j.core.TeamCityProjectBuildType;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bilal Asif Mirza (github.com/BilalAM)
 */
public class TeamCityHelper {

        private static final String PROJECTS = "http://localhost:8111/app/rest/projects/";
        private static String SINGLE_PROJECT = "http://localhost:8111/app/rest/projects/id:%s";
        private static String BUILDTYPE_HISTORY_OF_BUILDTYPE = "http://localhost:8111/app/rest/buildTypes/%s/builds";
        private static String BUILD = "http://localhost:8111/app/rest/builds/id:%s";

        private static SAXReader xmlReader = new SAXReader();
        private static TeamCityParser parser = new TeamCityParser();

        private static TeamCityHelper instance = null;

        public static TeamCityHelper getTeamCityHelper() {
                if (instance == null) {
                        return new TeamCityHelper();
                } else {
                        return instance;
                }
        }

        private TeamCityHelper() {

        }

        public void setCredentials(String userName, String password) {
                TeamCityRestUtils.initiateAuthenticationFeature(userName, password);
        }

        /**
         * Returns a list of all projects made in Teamcity .
         *
         * @return : List of Node objects of all projects
         */
        public List<TeamCityProject> getAllProjects() {
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
        public TeamCityProject getProject(String projectID) {
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
        public List<TeamCityProjectBuildType> getAllbuildTypes(String projectID) {
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
                                List<TeamCityProjectBuild> buildHistory = getBuildHistoryOfBuildType(
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
        public List<TeamCityProjectBuild> getBuildHistoryOfBuildType(String buildTypeId) {
                List<TeamCityProjectBuild> buildHistory = new ArrayList<TeamCityProjectBuild>();
                List<Node> buildHistoryNodes;
                String buildHistoryUrl = String.format(BUILDTYPE_HISTORY_OF_BUILDTYPE, buildTypeId);
                String buildHistoryResponse;
                Document buildHistoryDocument;
                try {
                        buildHistoryResponse = (String) TeamCityRestUtils.get(buildHistoryUrl, String.class);
                        buildHistoryDocument = xmlReader.read(new StringReader(buildHistoryResponse));
                        buildHistoryNodes = buildHistoryDocument.selectNodes("/builds/build");
                        for (Node buildHistoryNode : buildHistoryNodes) {
                                // for each build history node , we are going to take the id
                                // of each build , fire a url for that particular build and
                                // further get detailed information about that build such as
                                // time started , ended and etc .
                                Element buildElement = (Element) buildHistoryNode;
                                String buildUrl = String.format(BUILD, buildElement.attributeValue("id"));
                                String buildResponse = (String) TeamCityRestUtils.get(buildUrl, String.class);
                                Document buildDocument = xmlReader.read(new StringReader(buildResponse));
                                Node buildNode = buildDocument.selectSingleNode("/build");
                                TeamCityProjectBuild build = parser.parseBuildHistoryNode(buildNode);
                                // we have all the stuff , now add it in the list of build history.
                                buildHistory.add(build);
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return buildHistory;
        }

}
