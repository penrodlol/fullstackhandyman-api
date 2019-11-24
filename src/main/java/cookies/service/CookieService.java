package cookies.service;

import java.util.List;

import cookies.models.Cookie;
import cookies.models.CookieMap;
import cookies.models.CookieMapsContainer;

public interface CookieService {
    public List<CookieMapsContainer> getCookieMapsContainers();
    public List<CookieMap> getCookieMaps(Integer containerNum);
    public List<Cookie> getCookies(Integer mapNum);
    public void createCookieMapContainer(String name);
    public void createCookies(Integer containerNum, String mapName, List<Cookie> cookies);
}