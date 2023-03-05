package example.com.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartDto {
    private String id;
    private Double totalSum;
    private Boolean active;
}
