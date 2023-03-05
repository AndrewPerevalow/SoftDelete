package example.com.spec;

import example.com.domain.ShoppingCartEntity;
import example.com.domain.ShoppingCartEntity_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

public class ShoppingCartSpec {
    public static Specification<ShoppingCartEntity> hasIds(Collection<String> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return null;
        }
        return (root, query, cb) -> root.get(ShoppingCartEntity_.id).in(ids);
    }

    public static Specification<ShoppingCartEntity> hasTotalSum(Double totalSum) {
        if (totalSum == null) {
            return null;
        }
        return (root, query, cb) -> cb.equal(root.get(ShoppingCartEntity_.totalSum), totalSum);
    }

    public static Specification<ShoppingCartEntity> isActive(Boolean active) {
        if (active == null) {
            return null;
        }
        return (root, query, cb) -> active ? cb.isTrue(root.get(ShoppingCartEntity_.active)) : cb.isFalse(root.get(ShoppingCartEntity_.active));
    }
}
