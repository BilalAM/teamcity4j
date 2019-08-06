package bilal.teamcity4j.core;

import java.util.List;

/**
 * @author Bilal Asif Mirza (github.com/BilalAM)
 */
public class TeamCityProject {
        private String projectName;
        private String projectId;
        private String projectDescription;
        private String projectWebUrl;
        private List<TeamCityProjectBuildType> projectbuildTypes;

        public TeamCityProject() {

        }

        public TeamCityProject(String projectName, String projectId, String projectDescription, String projectWebUrl,
                List<TeamCityProjectBuildType> projectbuildTypes) {
                this.projectName = projectName;
                this.projectId = projectId;
                this.projectDescription = projectDescription;
                this.projectWebUrl = projectWebUrl;
                this.projectbuildTypes = projectbuildTypes;
        }

        public String getProjectName() {
                return projectName;
        }

        public void setProjectName(String projectName) {
                this.projectName = projectName;
        }

        public String getProjectId() {
                return projectId;
        }

        public void setProjectId(String projectId) {
                this.projectId = projectId;
        }

        public String getProjectDescription() {
                return projectDescription;
        }

        public void setProjectDescription(String projectDescription) {
                this.projectDescription = projectDescription;
        }

        public String getProjectWebUrl() {
                return projectWebUrl;
        }

        public void setProjectWebUrl(String projectWebUrl) {
                this.projectWebUrl = projectWebUrl;
        }

        public List<TeamCityProjectBuildType> getProjectbuildTypes() {
                return projectbuildTypes;
        }

        public void setProjectbuildTypes(List<TeamCityProjectBuildType> projectbuildTypes) {
                this.projectbuildTypes = projectbuildTypes;
        }

        @Override public String toString() {
                return "TeamCityProject@[id:" + projectId + "] [name:" + projectName + "] [description:" + projectDescription + "] [" + "web-url:" + projectWebUrl + "] [TeamCityProjectBuildType:"
                        + projectbuildTypes + "]";
        }
}
