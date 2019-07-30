package bilal.teamcity4j.core;

import org.dom4j.Element;
import org.dom4j.Node;

public class TeamCityParser {

        /**
         * Parses a single 'project' node and constructs a TeamCityProject object out of it .
         *
         * @param projectNode
         * @return
         */
        public TeamCityProject getSingleProjectFromAllProjects(Node projectNode) {
                TeamCityProject project = new TeamCityProject();
                try {
                        Element projectElement = (Element) projectNode;
                        project.setProjectId(projectElement.attributeValue("id"));
                        project.setProjectName(projectElement.attributeValue("name"));
                        project.setProjectWebUrl(projectElement.attributeValue("webUrl"));
                        project.setProjectDescription(projectElement.attributeValue("description"));
                        project.setProjectBuildSteps(null);
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return project;
        }
}
