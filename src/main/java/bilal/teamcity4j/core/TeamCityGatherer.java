package bilal.teamcity4j.core;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class TeamCityGatherer {


    private static String buildStepStatusesOfABuild = "http://teamcity:8111/app/rest/buildTypes/%s/builds";
    private static String buildStatusOfABuild= "http://teamcity:8111/app/rest/builds/%s";
    private static String projects = "http://teamcity:8111/app/test/projects/";
    private static SAXReader xmlReader = new SAXReader();


    /**
     * Returns a list of all build steps of a particular project
     * @param projectID
     * @return
     */
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
     * @param buildStepName
     * @return
     */
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
     * @return
     */
    public static Node getBuildStatusOfBuild(String buildID){
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
}
