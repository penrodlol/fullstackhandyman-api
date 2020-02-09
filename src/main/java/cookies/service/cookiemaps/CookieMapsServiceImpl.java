package cookies.service.cookiemaps;

import java.util.List;

import org.springframework.stereotype.Service;

import cookies.models.CookieMap;

@Service
public class CookieMapsServiceImpl implements CookieMapsService {
    CookieMapsPersistor cookieMapsPersistor;

    public CookieMapsServiceImpl(CookieMapsPersistor cookieMapsPersistor) {
        this.cookieMapsPersistor = cookieMapsPersistor;
    }

    @Override
    public List<CookieMap> getCookieMaps(Long containerNum) {
        return this.cookieMapsPersistor.getCookieMaps(containerNum);
    }
}