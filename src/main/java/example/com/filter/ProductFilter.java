package example.com.filter;

import example.com.domain.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static example.com.spec.ProductSpec.hasIds;
import static example.com.spec.ProductSpec.hasName;
import static example.com.spec.ProductSpec.hasPrice;
import static example.com.spec.ProductSpec.isActive;
import static org.springframework.data.jpa.domain.Specification.where;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductFilter implements Filter<ProductEntity> {
    private List<String> ids;
    private String name;
    private Integer price;
    private Boolean active;
    @Override
    public Specification<ProductEntity> toSpecification() {
        return where(hasIds(ids))
                .and(hasName(name))
                .and(hasPrice(price))
                .and(isActive(active));
    }
}
