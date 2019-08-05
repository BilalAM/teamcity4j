package bilal.teamcity4j.core;

import java.util.List;

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
