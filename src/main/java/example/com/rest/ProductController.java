package example.com.rest;

import example.com.dto.ProductDto;
import example.com.filter.ProductFilter;
import example.com.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public Page<ProductDto> findAll(@RequestBody ProductFilter filter, Pageable pageable) {
        return service.findAll(filter, pageable);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @DeleteMapping
    public void deleteAll(@RequestBody List<String> ids) {
        service.deleteAll(ids);
    }
}
