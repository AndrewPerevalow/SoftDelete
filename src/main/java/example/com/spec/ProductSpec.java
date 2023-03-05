package example.com.spec;

import example.com.domain.ProductEntity;
import example.com.domain.ProductEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;

public class ProductSpec {
    public static Specification<ProductEntity> hasIds(Collection<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return null;
        }
        return (root, query, cb) -> root.get(ProductEntity_.id).in(ids);
    }

    public static Specification<ProductEntity> hasName(String name) {
        if (!StringUtils.hasText(name)) {
            return null;
        }
        return (root, query, cb) -> cb.equal(root.get(ProductEntity_.name), name);
    }

    public static Specification<ProductEntity> hasPrice(Integer price) {
        if (price == null) {
            return null;
        }
        return (root, query, cb) -> cb.equal(root.get(ProductEntity_.price), price);
    }

    public static Specification<ProductEntity> isActive(Boolean active) {
        if (active == null) {
            return null;
        }
        return (root, query, cb) -> active ? cb.isTrue(root.get(ProductEntity_.active)) : cb.isFalse(root.get(ProductEntity_.active));
    }
}
