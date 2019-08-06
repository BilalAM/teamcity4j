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

import java.util.List;

/**
 * @author Bilal Asif Mirza (github.com/BilalAM)
 */
public class TeamCityProjectBuildType {
        private String buildTypeID;
        private String buildTypeName;
        private String projectName;
        private String buildTypeWebUrl;
        private List<TeamCityBuild> buildHistory;

        public String getBuildTypeID() {
                return buildTypeID;
        }

        public void setBuildTypeID(String buildTypeID) {
                this.buildTypeID = buildTypeID;
        }

        public String getBuildTypeName() {
                return buildTypeName;
        }

        public void setBuildTypeName(String buildTypeName) {
                this.buildTypeName = buildTypeName;
        }

        public String getProjectName() {
                return projectName;
        }

        public void setProjectName(String projectName) {
                this.projectName = projectName;
        }

        public List<TeamCityBuild> getBuildHistory() {
                return buildHistory;
        }

        public void setBuildHistory(List<TeamCityBuild> buildHistory) {
                this.buildHistory = buildHistory;
        }

        public String getBuildTypeWebUrl() {
                return buildTypeWebUrl;
        }

        public void setBuildTypeWebUrl(String buildTypeWebUrl) {
                this.buildTypeWebUrl = buildTypeWebUrl;
        }
}
