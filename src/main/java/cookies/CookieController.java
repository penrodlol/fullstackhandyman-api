package cookies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cookies.models.CookieTemplate;
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
    public List<CookieTemplate> getCookies() {
        return this.cookieService.getCookieTemplates();
    }

    @PostMapping("/create")
    public CookieTemplate createCookie(@RequestBody CookieTemplate cookieTemplate) {
        return this.cookieService.createCookie(cookieTemplate);
    }
}