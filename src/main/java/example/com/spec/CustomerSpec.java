package example.com.spec;

import example.com.domain.CustomerEntity;
import example.com.domain.CustomerEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;

public class CustomerSpec {
    public static Specification<CustomerEntity> hasIds(Collection<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return null;
        }
        return (root, query, cb) -> root.get(CustomerEntity_.id).in(ids);
    }

    public static Specification<CustomerEntity> hasName(String name) {
        if (!StringUtils.hasText(name)) {
            return null;
        }
        return (root, query, cb) -> cb.equal(root.get(CustomerEntity_.name), name);
    }

    public static Specification<CustomerEntity> hasAddress(String address) {
        if (!StringUtils.hasText(address)) {
            return null;
        }
        return (root, query, cb) -> cb.equal(root.get(CustomerEntity_.address), address);
    }

    public static Specification<CustomerEntity> isActive(Boolean active) {
        if (active == null) {
            return null;
        }
        return (root, query, cb) -> active ? cb.isTrue(root.get(CustomerEntity_.active)) : cb.isFalse(root.get(CustomerEntity_.active));
    }
}
