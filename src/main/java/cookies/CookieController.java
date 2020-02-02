package cookies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cookies.models.CookieMapsContainer;
import cookies.service.CookieService;

@CrossOrigin
@RestController
@RequestMapping("/com/fullstackhandyman/api/cookie")
public class CookieController {
    
    @Autowired
    private CookieService cookieService;

    public CookieController(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    @GetMapping("containers")
    public List<CookieMapsContainer> getCookieMapsContainer() {
        return this.cookieService.getCookieMapsContainers();
    }

    @PostMapping("create/container")
    public CookieMapsContainer createCookieMapContainer(@RequestHeader String name, @RequestHeader String tag) throws Exception {
        return this.cookieService.createCookieMapContainer(name, tag);
    }
}