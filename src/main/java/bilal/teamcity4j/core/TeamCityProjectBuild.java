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

/**
 * @author Bilal Asif Mirza (github.com/BilalAM)
 */
public class TeamCityProjectBuild {

        private String buildId;
        private String buildType;
        private String status;
        private String state;
        private String webUrl;
        private String startDate;

        private String endDate;

        public String getBuildId() {
                return buildId;
        }

        public void setBuildId(String buildId) {
                this.buildId = buildId;
        }

        public String getBuildType() {
                return buildType;
        }

        public void setBuildType(String buildType) {
                this.buildType = buildType;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public String getState() {
                return state;
        }

        public void setState(String state) {
                this.state = state;
        }

        public String getWebUrl() {
                return webUrl;
        }

        public void setWebUrl(String webUrl) {
                this.webUrl = webUrl;
        }

        public String getStartDate() {
                return startDate;
        }

        public void setStartDate(String startDate) {
                this.startDate = startDate;
        }

        public String getEndDate() {
                return endDate;
        }

        public void setEndDate(String endDate) {
                this.endDate = endDate;
        }

}
