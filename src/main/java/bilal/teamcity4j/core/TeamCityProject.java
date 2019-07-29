package bilal.teamcity4j.core;

import java.util.List;

public class TeamCityProject {
        private String projectName;
        private String projectId;
        private String projectDescription;
        private String projectWebUrl;
        private List<TeamCityProjectBuildSteps> projectBuilds;

        public TeamCityProject() {

        }

        public TeamCityProject(String projectName, String projectId, String projectDescription, String projectWebUrl,
                List<TeamCityProjectBuildSteps> projectBuilds) {
                this.projectName = projectName;
                this.projectId = projectId;
                this.projectDescription = projectDescription;
                this.projectWebUrl = projectWebUrl;
                this.projectBuilds = projectBuilds;
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

        public List<TeamCityProjectBuildSteps> getProjectBuilds() {
                return projectBuilds;
        }

        public void setProjectBuilds(List<TeamCityProjectBuildSteps> projectBuilds) {
                this.projectBuilds = projectBuilds;
        }

}
