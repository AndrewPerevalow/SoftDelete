package example.com.service;

import example.com.dto.ShopDto;
import example.com.filter.ShopFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShopService {
    Page<ShopDto> findAll(ShopFilter filter, Pageable pageable);
    void delete(String id);
    void deleteAll(List<String> ids);
}
