package cookies.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CookieTemplate {
    private Long templateNum;
    private Long templateMapNum;
    private String name;
    private int typeNum;
}