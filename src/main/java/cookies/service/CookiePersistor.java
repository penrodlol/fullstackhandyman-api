package cookies.service;

import java.util.List;

import cookies.models.CookieMapsContainer;

public interface CookiePersistor {
    List<CookieMapsContainer> getCookieMapsContainers();
    CookieMapsContainer insertCookieMapContainer(String name);
}