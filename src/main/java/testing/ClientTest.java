package testing;

import bilal.teamcity4j.core.TeamCityGatherer;
import bilal.teamcity4j.core.TeamCityProject;

public class ClientTest {
        public static void main(String[] args) {
                TeamCityProject selfErp = TeamCityGatherer.getProject("SelfErp");
        }
}
