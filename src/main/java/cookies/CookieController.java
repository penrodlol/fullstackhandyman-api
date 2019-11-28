package cookies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cookies.models.Cookie;
import cookies.models.CookieMapWrapper;
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

    @GetMapping("/container")
    public List<CookieMapsContainer> getCookieMapsContainer() {
        return this.cookieService.getCookieMapsContainers();
    }

    @GetMapping("/maps")
    public List<CookieMapWrapper> getCookies(@RequestHeader(value = "containerNum") Integer containerNum) {
        return this.cookieService.getCookies(containerNum);
    }

    @PostMapping("/create/container")
    public void createCookieMapContainer(@RequestHeader(value = "name") String name) {
        this.cookieService.createCookieMapContainer(name);
    }

    @PostMapping("/create/cookies")
    public void createCookies(
        @RequestHeader(value = "containerNum") Integer containerNum,
        @RequestHeader(value = "mapName") String mapName,
        @RequestBody List<Cookie> cookies) {
            this.cookieService.createCookies(containerNum, mapName, cookies);
    }
}