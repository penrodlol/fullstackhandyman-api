package cookies.service;

import java.util.List;

import cookies.models.CookieMapsContainer;

public interface CookiePersistor {
    public List<CookieMapsContainer> getCookieMapsContainers();
    public CookieMapsContainer insertCookieMapContainer(String name);
}