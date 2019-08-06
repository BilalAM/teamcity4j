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
package bilal.teamcity4j.core;

import org.dom4j.Element;
import org.dom4j.Node;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Bilal Asif Mirza (github.com/BilalAM)
 */
public class TeamCityParser {

        private static final DateTimeFormatter DATE_TIME_FORMATTER_RAW = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmssZ");
        private static final DateTimeFormatter DATE_TIME_FORMATTER_PRETTY = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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
                        LocalDateTime startDateRaw = LocalDateTime.parse(buildHistoryElement.element("startDate").getStringValue(),
                                DATE_TIME_FORMATTER_RAW);
                        LocalDateTime endDateRaw = LocalDateTime.parse(buildHistoryElement.element("finishDate").getStringValue(),
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
