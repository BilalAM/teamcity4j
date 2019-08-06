package bilal.teamcity4j.core;

import org.dom4j.Element;
import org.dom4j.Node;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Bilal Asif Mirza (github.com/BilalAM)
 */
public class TeamCityParser {

        private static final DateTimeFormatter DATE_TIME_FORMATTER_RAW = DateTimeFormatter
                .ofPattern("yyyyMMdd'T'HHmmssZ");
        private static final DateTimeFormatter DATE_TIME_FORMATTER_PRETTY = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss");

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

        /**
         * Parses a complete build node and extract important information out of it !
         *
         * @param buildHistoryNode
         * @return
         */
        public TeamCityBuild parseBuildHistoryNode(Node buildHistoryNode) {
                TeamCityBuild teamCityBuild = new TeamCityBuild();
                try {
                        Element buildHistoryElement = (Element) buildHistoryNode;
                        LocalDateTime startDateRaw = LocalDateTime
                                .parse(buildHistoryElement.element("startDate").getStringValue(),
                                        DATE_TIME_FORMATTER_RAW);
                        LocalDateTime endDateRaw = LocalDateTime
                                .parse(buildHistoryElement.element("finishDate").getStringValue(),
                                        DATE_TIME_FORMATTER_RAW);

                        teamCityBuild.setStartDate(startDateRaw.format(DATE_TIME_FORMATTER_PRETTY));
                        teamCityBuild.setEndDate(endDateRaw.format(DATE_TIME_FORMATTER_PRETTY));

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
