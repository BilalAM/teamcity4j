package testing;

import bilal.teamcity.TeamCityHelper;
import bilal.teamcity4j.core.TeamCityProject;

public class ClientTest {
        public static void main(String[] args) {
                TeamCityProject teamCityProject = TeamCityHelper.getProject("SelfErp");
                System.out.println("dsdsds");
                //   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmssZ");
                //  LocalDateTime a=  LocalDateTime.parse("20190605T193716+0500",formatter);
                //   System.out.println(a.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
}
