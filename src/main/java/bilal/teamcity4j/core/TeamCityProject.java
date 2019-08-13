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

    @Override
    public String toString() {
        return "TeamCityProject@[id:" + projectId + "] [name:" + projectName + "] [description:" + projectDescription
                + "] [" + "web-url:" + projectWebUrl + "] [TeamCityProjectBuildType:" + projectbuildTypes + "]";
    }
}
