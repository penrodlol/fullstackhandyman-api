package cookies.service.cookiemapscontainer;

import java.util.List;

import cookies.models.CookieMapsContainer;

public interface CookieMapsContainerPersistor {
    List<CookieMapsContainer> getCookieMapsContainers();
    CookieMapsContainer insertCookieMapContainer(String name, String tag) throws Exception;
    CookieMapsContainer editCookieMapContainer(CookieMapsContainer cookieMapsContainer) throws Exception;
    Long deleteCookieMapContainer(Long containerNum) throws Exception;
}