package example.com.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String id;
    private String name;
    private Integer price;
    private Boolean active;
}
