package example.com.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private String id;
    private String name;
    private String address;
    private Boolean active;
}
