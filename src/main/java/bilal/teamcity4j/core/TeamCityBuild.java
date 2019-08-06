package bilal.teamcity4j.core;

/**
 * @author Bilal Asif Mirza (github.com/BilalAM)
 */
public class TeamCityBuild {

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
