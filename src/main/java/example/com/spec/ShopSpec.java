package example.com.spec;

import example.com.domain.ShopEntity;
import example.com.domain.ShopEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;

public class ShopSpec {
    public static Specification<ShopEntity> hasIds(Collection<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return null;
        }
        return (root, query, cb) -> root.get(ShopEntity_.id).in(ids);
    }

    public static Specification<ShopEntity> hasName(String name) {
        if (!StringUtils.hasText(name)) {
            return null;
        }
        return (root, query, cb) -> cb.equal(root.get(ShopEntity_.name), name);
    }

    public static Specification<ShopEntity> isActive(Boolean active) {
        if (active == null) {
            return null;
        }
        return (root, query, cb) -> active ? cb.isTrue(root.get(ShopEntity_.active)) : cb.isFalse(root.get(ShopEntity_.active));
    }
}
