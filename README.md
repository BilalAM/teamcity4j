# teamcity4j
A simple,easy to use and configurable helper for teamcity written in Java ! 

Use bilal.teamcity4j.TeamCityHelper class to use this . 

The structure of object TeamCityProject is like 1 TeamCityProject ---has---> List of TeamCityBuildTypes ---has--> List of TeamCityBuildType history .

Running TeamCityHelper.getProject(projectId) will give you a TeamCityProject object with the above contents already prepared for you . 


 * @author Bilal Asif Mirza (github.com/BilalAM)
 