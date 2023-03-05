package example.com.filter;

import example.com.domain.ShoppingCartEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static example.com.spec.ShoppingCartSpec.hasIds;
import static example.com.spec.ShoppingCartSpec.hasTotalSum;
import static example.com.spec.ShoppingCartSpec.isActive;
import static org.springframework.data.jpa.domain.Specification.where;

@Getter
@Setter
@Builder
public class ShoppingCartFilter implements Filter<ShoppingCartEntity> {
    private List<String> ids;
    private Double totalSum;
    private Boolean active;
    @Override
    public Specification<ShoppingCartEntity> toSpecification() {
        return where(hasIds(ids))
                .and(hasTotalSum(totalSum))
                .and(isActive(active));
    }
}
