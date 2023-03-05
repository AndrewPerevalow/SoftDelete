package example.com.service;

import example.com.dto.CustomerDto;
import example.com.filter.CustomerFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<CustomerDto> findAll(CustomerFilter filter, Pageable pageable);
    void delete(String id);
    void deleteAll(List<String> ids);
}
