package cookies.service.cookiemaps;

import java.util.List;

import cookies.models.CookieMap;

public interface CookieMapsPersistor {
    List<CookieMap> getCookieMaps(Long containerNum);
}