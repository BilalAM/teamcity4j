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
package example;

import bilal.teamcity4j.TeamCityHelper;
import bilal.teamcity4j.core.TeamCityProject;
import bilal.teamcity4j.core.TeamCityProjectBuild;
import bilal.teamcity4j.core.TeamCityProjectBuildType;

import java.util.List;

public class ClientTest {
        public static void main(String[] args) {

                //            Get instance of TeamCityHelper
                //==============================================================================
                TeamCityHelper helper = TeamCityHelper.getTeamCityHelper();
                // set credentials to login.
                helper.setCredentials("admin", "admin");


                //                Getting basic information about the project
                //==================================================================================

                TeamCityProject myCoolProject = helper.getProject("SelfErp");

                System.out.println("PROJECT NAME        --> " + myCoolProject.getProjectName());
                System.out.println("PROJECT ID          --> " + myCoolProject.getProjectId());
                System.out.println("PROJECT DESCRIPTION --> " + myCoolProject.getProjectDescription());
                System.out.println("PROJECT URL         --> " + myCoolProject.getProjectWebUrl());
                //==================================================================================

                //                Getting the build types of that project
                //==================================================================================
                List<TeamCityProjectBuildType> buildTypes = myCoolProject.getProjectbuildTypes();
                for (TeamCityProjectBuildType buildType : buildTypes) {
                        System.out.println("--------> BUILD TYPE NAME  --> " + buildType.getBuildTypeName());
                        System.out.println("--------> BUILD TYPE ID    --> " + buildType.getBuildTypeID());
                        System.out.println("--------> BUILD TYPE URL   --> " + buildType.getBuildTypeWebUrl());

                        //         Getting the build history of that project and information related to the builds
                        //=================================================================================================
                        for (TeamCityProjectBuild teamCityProjectBuild : buildType.getBuildHistory()) {
                                System.out.println(
                                        "---------------> BUILD ID     --> " + teamCityProjectBuild.getBuildId());
                                System.out.println(
                                        "---------------> BUILD TYPE   --> " + teamCityProjectBuild.getBuildType());
                                System.out.println(
                                        "---------------> BUILD STATE  --> " + teamCityProjectBuild.getState());
                                System.out.println(
                                        "---------------> BUILD STATUS --> " + teamCityProjectBuild.getStatus());
                                System.out.println(
                                        "---------------> START DATE   --> " + teamCityProjectBuild.getStartDate());
                                System.out.println(
                                        "---------------> END DATE     --> " + teamCityProjectBuild.getEndDate());
                        }
                        System.out.println("\n");

                }
                System.out.println("\n");

        }

}
