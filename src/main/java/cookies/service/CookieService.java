package cookies.service;

import java.util.List;

import cookies.models.Cookie;
import cookies.models.CookieMapWrapper;
import cookies.models.CookieMapsContainer;

public interface CookieService {
    public List<CookieMapsContainer> getCookieMapsContainers();
    public List<CookieMapWrapper> getCookies(Integer containerNum);
    public CookieMapsContainer createCookieMapContainer(String name);
    public void createCookies(Integer containerNum, String mapName, List<Cookie> cookies);
}