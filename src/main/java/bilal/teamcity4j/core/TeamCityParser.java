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

        public TeamCityProjectBuildType parsebuildTypeNode(Node buildTypeNode) {
                TeamCityProjectBuildType teamCityProjectBuildType = new TeamCityProjectBuildType();
                try {
                        Element buildTypeElement = (Element) buildTypeNode;
                        teamCityProjectBuildType.setBuildTypeID(buildTypeElement.attributeValue("id"));
                        teamCityProjectBuildType.setBuildTypeName(buildTypeElement.attributeValue("name"));
                        teamCityProjectBuildType.setProjectName(buildTypeElement.attributeValue("projectName"));
                        teamCityProjectBuildType.setBuildTypeWebUrl(buildTypeElement.attributeValue("href"));
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return teamCityProjectBuildType;
        }

        public TeamCityBuild parseBuildHistoryNode(Node buildHistoryNode) {
                TeamCityBuild teamCityBuild = new TeamCityBuild();
                try {
                        Element buildHistoryElement = (Element) buildHistoryNode;
                        teamCityBuild.setBuildId(buildHistoryElement.attributeValue("id"));
                        teamCityBuild.setBuildType(buildHistoryElement.attributeValue("buildTypeId"));
                        teamCityBuild.setState(buildHistoryElement.attributeValue("state"));
                        teamCityBuild.setStatus(buildHistoryElement.attributeValue("status"));
                        teamCityBuild.setWebUrl(buildHistoryElement.attributeValue("href"));
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return teamCityBuild;
        }
}
