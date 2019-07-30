package bilal.teamcity4j.core;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class TeamCityGatherer {

    private static String buildStepStatusesOfABuild = "http://localhost:8111/app/rest/buildTypes/%s/builds";
    private static String buildStatusOfABuild = "http://localhost:8111/app/rest/builds/%s";
        private static final String PROJECTS = "http://localhost:8111/app/rest/projects/";
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
                        TeamCityProject teamCityProject = parser.getSingleProjectFromAllProjects(projectNode);
                        allProjects.add(teamCityProject);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allProjects;
    }


    /**
     * Returns a list of all build steps of a particular project
     * @param projectID : The project id of the url
     * @return : List of Node objects that consists of all the build steps of a project.

    public static List<Node> getAllBuildSteps(String projectID){
        List<Node> buildNameNodes = new ArrayList<Node>();
        try {
            String projectBuilds = ((String) TeamCityRestUtils.get(projects + projectID, String.class));
            Document projectBuildsDocuments = xmlReader.read(new StringReader(projectBuilds));
            buildNameNodes = projectBuildsDocuments.selectNodes("/project/buildTypes/buildType");
        }catch (Exception e){
            e.printStackTrace();
        }
        return buildNameNodes;
    }

    /**
     * Returns a list of all builds history of a particular build step .
     * @param buildStepName : Build step name of a particular project .
     * @return : List of Node objects that are all the builds currently made of that projects

    public static List<Node> getAllBuildsOfBuildStep(String buildStepName){
        List<Node> allBuildsOfBuildStep = new ArrayList<Node>();
        try{
            String urlToHit = String.format(buildStepStatusesOfABuild,buildStepName);
            String outputOfUrl = ((String)TeamCityRestUtils.get(urlToHit,String.class));
            Document buildStepStatusesDocument = xmlReader.read(new StringReader(outputOfUrl));
            allBuildsOfBuildStep = buildStepStatusesDocument.selectNodes("builds/build");
        }catch (Exception e){
            e.printStackTrace();
        }
        return allBuildsOfBuildStep;
    }

    /**
     * Returns build information for a specific build ID
     * @param buildID
     * @return public static Node getBuildStatusOfBuild(String buildID){
        Node buildStatus = null;
        try{
            String urlToHit = String.format(buildStatusOfABuild,buildID);
            String outputOfUrl = ((String)TeamCityRestUtils.get(urlToHit,String.class));
            Document buildStatusDocument = xmlReader.read(new StringReader(outputOfUrl));
            buildStatus = buildStatusDocument.selectSingleNode("/build");

        }catch (Exception e){
            e.printStackTrace();
        }
        return buildStatus;
    }
     */
}
