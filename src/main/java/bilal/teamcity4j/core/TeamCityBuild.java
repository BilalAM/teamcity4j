package bilal.teamcity4j.core;

import java.time.LocalDateTime;

public class TeamCityBuild {

        private String buildId;
        private String buildType;
        private String status;
        private String state;
        private String webUrl;
        private LocalDateTime startDate;

        private LocalDateTime endDate;

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

        public LocalDateTime getStartDate() {
                return startDate;
        }

        public void setStartDate(LocalDateTime startDate) {
                this.startDate = startDate;
        }

        public LocalDateTime getEndDate() {
                return endDate;
        }

        public void setEndDate(LocalDateTime endDate) {
                this.endDate = endDate;
        }



}
