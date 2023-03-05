package example.com.filter;

import example.com.domain.CustomerEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static example.com.spec.CustomerSpec.hasAddress;
import static example.com.spec.CustomerSpec.hasIds;
import static example.com.spec.CustomerSpec.hasName;
import static example.com.spec.CustomerSpec.isActive;
import static org.springframework.data.jpa.domain.Specification.where;

@Getter
@Setter
@Builder
public class CustomerFilter implements Filter<CustomerEntity> {
    private List<String> ids;
    private String name;
    private String address;
    private Boolean active;
    @Override
    public Specification<CustomerEntity> toSpecification() {
        return where(hasIds(ids))
                .and(hasName(name))
                .and(hasAddress(address))
                .and(isActive(active));
    }
}
