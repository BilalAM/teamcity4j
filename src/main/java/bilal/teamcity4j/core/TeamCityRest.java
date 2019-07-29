package bilal.teamcity4j.core;

import javax.ws.rs.core.Response;

public interface TeamCityRest {

    Response post(String url , Object o);

    Object get(String url , Class clazz);
}
