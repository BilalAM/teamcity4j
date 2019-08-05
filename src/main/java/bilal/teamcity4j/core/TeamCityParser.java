package bilal.teamcity4j.core;

import org.dom4j.Element;
import org.dom4j.Node;

public class TeamCityParser {

        public TeamCityProject getSingleProjectFromSingleNode(Node projectNode) {
                TeamCityProject project = new TeamCityProject();
                try {
                        Element projectElement = (Element) projectNode;
                        project.setProjectId(projectElement.attributeValue("id"));
                        project.setProjectName(projectElement.attributeValue("name"));
                        project.setProjectWebUrl(projectElement.attributeValue("webUrl"));
                        project.setProjectDescription(projectElement.attributeValue("description"));
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return project;
        }

        public TeamCityProjectBuildSteps parseBuildStepNode(Node buildStepNode) {
                TeamCityProjectBuildSteps teamCityProjectBuildSteps = new TeamCityProjectBuildSteps();
                try {
                        Element buildStepElement = (Element) buildStepNode;
                        teamCityProjectBuildSteps.setBuildTypeID(buildStepElement.attributeValue("id"));
                        teamCityProjectBuildSteps.setBuildTypeName(buildStepElement.attributeValue("name"));
                        teamCityProjectBuildSteps.setProjectName(buildStepElement.attributeValue("projectName"));
                        teamCityProjectBuildSteps.setBuildTypeWebUrl(buildStepElement.attributeValue("href"));
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return teamCityProjectBuildSteps;
        }

        public TeamCityBuild parseBuildHistoryNode(Node buildHistoryNode) {
                TeamCityBuild teamCityBuild = new TeamCityBuild();
                try {
                        Element buildHistoryElement = (Element) buildHistoryNode;
                        teamCityBuild.setBuildId(buildHistoryElement.attributeValue("id"));
                        teamCityBuild.setBuildType(buildHistoryElement.attributeValue("buildTypeId"));
                        teamCityBuild.setState(buildHistoryElement.attributeValue("state"));
                        teamCityBuild.setStatus(buildHistoryElement.attributeValue("status"));
                        teamCityBuild.setStatus(buildHistoryElement.attributeValue("href"));
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return teamCityBuild;
        }
}
