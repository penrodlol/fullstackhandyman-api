package cookies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cookies.models.CookieMapsContainer;
import cookies.service.cookiemapscontainer.CookieMapsContainerService;

@CrossOrigin
@RestController
@RequestMapping("/com/fullstackhandyman/api/cookie")
public class CookieController {
    
    @Autowired
    private CookieMapsContainerService cookieMapsContainerService;

    public CookieController(CookieMapsContainerService cookieMapsContainerService) {
        this.cookieMapsContainerService = cookieMapsContainerService;
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
}