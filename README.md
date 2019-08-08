# teamcity4j
A simple,easy to use and configurable helper for teamcity written in Java ! 

### How to use 
- See <b>example.ClientTest</b> on how to use this .  

 
 I have a project named Self Erp in my locally deployed TeamCity server with default username and password.
 
 The username and password are defined in the <b>bilal.teamcity4j.TeamCityHelper</b> class
   
 <b>Sample output when running example.ClientTest :</b> 
 
````
 PROJECT NAME        --> Self Erp
 PROJECT ID          --> SelfErp
 PROJECT DESCRIPTION --> null
 PROJECT URL         --> http://192.168.8.102:8111/project.html?projectId=SelfErp
 --------> BUILD TYPE NAME  --> Build
 --------> BUILD TYPE ID    --> SelfErp_Build
 --------> BUILD TYPE URL   --> /app/rest/buildTypes/id:SelfErp_Build
 ---------------> BUILD ID     --> 7
 ---------------> BUILD TYPE   --> SelfErp_Build
 ---------------> BUILD STATE  --> finished
 ---------------> BUILD STATUS --> FAILURE
 ---------------> START DATE   --> 2019-06-05 19:37:16
 ---------------> END DATE     --> 2019-06-05 20:09:08
 
 
 --------> BUILD TYPE NAME  --> TEST
 --------> BUILD TYPE ID    --> SelfErp_Test
 --------> BUILD TYPE URL   --> /app/rest/buildTypes/id:SelfErp_Test
 ---------------> BUILD ID     --> 9
 ---------------> BUILD TYPE   --> SelfErp_Test
 ---------------> BUILD STATE  --> finished
 ---------------> BUILD STATUS --> SUCCESS
 ---------------> START DATE   --> 2019-07-29 20:10:29
 ---------------> END DATE     --> 2019-07-29 20:17:41

 @author Bilal Asif Mirza (github.com/BilalAM)
