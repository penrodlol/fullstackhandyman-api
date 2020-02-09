package cookies.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CookieMap {
    private Long mapNum, containerNum;

    @NotBlank(message = "Map name is manditory")
    @Size(min = 1, max = 150)
    private String name;
}