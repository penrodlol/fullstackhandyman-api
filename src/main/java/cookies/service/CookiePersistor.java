package cookies.service;

import java.util.List;

import cookies.models.CookieMapsContainer;

public interface CookiePersistor {
    List<CookieMapsContainer> getCookieMapsContainers();
    CookieMapsContainer insertCookieMapContainer(String name, String tag) throws Exception;
    CookieMapsContainer editCookieMapContainer(CookieMapsContainer cookieMapsContainer) throws Exception;
}