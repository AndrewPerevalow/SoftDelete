package example.com.filter;

import org.springframework.data.jpa.domain.Specification;

@FunctionalInterface
public interface Filter<T> {
    Specification<T> toSpecification();
}
