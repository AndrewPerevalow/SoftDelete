package example.com.filter;

import example.com.domain.ShopEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static example.com.spec.ShopSpec.hasIds;
import static example.com.spec.ShopSpec.hasName;
import static example.com.spec.ShopSpec.isActive;
import static org.springframework.data.jpa.domain.Specification.where;

@Getter
@Setter
@Builder
public class ShopFilter implements Filter<ShopEntity> {
    private List<String> ids;
    private String name;
    private Boolean active;
    @Override
    public Specification<ShopEntity> toSpecification() {
        return where(hasIds(ids))
                .and(hasName(name))
                .and(isActive(active));
    }
}
