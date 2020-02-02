package cookies.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CookieMapsContainer {
    private Long containerNum;

    @NotBlank(message = "Container name is manditory")
    @Size(min = 1, max = 150)
    private String name;

    @NotBlank(message = "Container tag is manditory")
    @Size(min = 1, max = 10)
    private String tag;
}