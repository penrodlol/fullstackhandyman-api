package cookies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cookies.service.CookieService;

@CrossOrigin
@RestController
@RequestMapping("/com/fullstackhandyman/api/cookies")
public class CookieController {
    
    @Autowired
    private CookieService cookieService;

    public CookieController(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    @GetMapping()
    public List<Cookie> getCookies() {
        return this.cookieService.getCookies();
    }
}