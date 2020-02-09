package cookies.service.cookiemaps;

import java.util.List;

import cookies.models.CookieMap;

public interface CookieMapsService {
    List<CookieMap> getCookieMaps(Long containerNum);
}