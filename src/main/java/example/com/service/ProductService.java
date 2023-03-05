package example.com.service;

import example.com.dto.ProductDto;
import example.com.filter.ProductFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<ProductDto> findAll(ProductFilter filter, Pageable pageable);
    void delete(String id);
    void deleteAll(List<String> ids);
}
