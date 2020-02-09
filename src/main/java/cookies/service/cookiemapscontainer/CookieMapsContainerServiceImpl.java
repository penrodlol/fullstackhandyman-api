package cookies.service.cookiemapscontainer;

import java.util.List;

import org.springframework.stereotype.Service;

import cookies.models.CookieMapsContainer;

@Service
public class CookieMapsContainerServiceImpl implements CookieMapsContainerService {
    private CookieMapsContainerPersistor cookieMapsContainerPersistor;

    public CookieMapsContainerServiceImpl(CookieMapsContainerPersistor cookieMapsContainerPersistor) {
        this.cookieMapsContainerPersistor = cookieMapsContainerPersistor;
    }

    @Override
    public List<CookieMapsContainer> getCookieMapsContainers() {
        return this.cookieMapsContainerPersistor.getCookieMapsContainers();
    }

    @Override
    public CookieMapsContainer createCookieMapContainer(String name, String tag) throws Exception {
        return this.cookieMapsContainerPersistor.insertCookieMapContainer(name, tag);
    }

    @Override
    public CookieMapsContainer editCookieMapContainer(CookieMapsContainer cookieMapsContainer) throws Exception {
        return this.cookieMapsContainerPersistor.editCookieMapContainer(cookieMapsContainer);
    }

    @Override
    public Long deleteCookieMapContainer(Long containerNum) throws Exception {
        return this.cookieMapsContainerPersistor.deleteCookieMapContainer(containerNum);
    }
}