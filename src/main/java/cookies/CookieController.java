package cookies;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cookies.models.CookieMap;
import cookies.models.CookieMapsContainer;
import cookies.service.cookiemaps.CookieMapsService;
import cookies.service.cookiemapscontainer.CookieMapsContainerService;

@CrossOrigin
@RestController
@RequestMapping("/com/fullstackhandyman/api/cookie")
public class CookieController {
    
    private CookieMapsContainerService cookieMapsContainerService;
    private CookieMapsService cookieMapsService;

    public CookieController(CookieMapsContainerService cookieMapsContainerService,
        CookieMapsService cookieMapsService) {
        this.cookieMapsContainerService = cookieMapsContainerService;
        this.cookieMapsService = cookieMapsService;
    }

    @GetMapping("containers")
    public List<CookieMapsContainer> getCookieMapsContainer() {
        return this.cookieMapsContainerService.getCookieMapsContainers();
    }

    @PostMapping("create/container")
    public CookieMapsContainer createCookieMapContainer(@RequestHeader String name, @RequestHeader String tag) throws Exception {
        return this.cookieMapsContainerService.createCookieMapContainer(name, tag);
    }

    @PutMapping("edit/container")
    public CookieMapsContainer editCookieMapContainer(@RequestBody CookieMapsContainer cookieMapsContainer) throws Exception {
        return this.cookieMapsContainerService.editCookieMapContainer(cookieMapsContainer);
    }

    @DeleteMapping("delete/container")
    public Long deleteCookieMapContainer(@RequestHeader Long containerNum) throws Exception {
        return this.cookieMapsContainerService.deleteCookieMapContainer(containerNum);
    }

    @GetMapping("maps")
    public List<CookieMap> getCookieMaps(@RequestHeader Long containerNum) {
        return this.cookieMapsService.getCookieMaps(containerNum);
    }
}