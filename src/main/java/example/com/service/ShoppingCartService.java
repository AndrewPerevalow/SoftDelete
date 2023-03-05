package example.com.service;

import example.com.dto.ShoppingCartDto;
import example.com.filter.ShoppingCartFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShoppingCartService {
    Page<ShoppingCartDto> findAll(ShoppingCartFilter filter, Pageable pageable);
    void delete(String id);
    void deleteAll(List<String> ids);
}
