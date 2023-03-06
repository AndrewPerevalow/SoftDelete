package example.com.rest;

import example.com.dto.ShoppingCartDto;
import example.com.filter.ShoppingCartFilter;
import example.com.service.ShoppingCartService;
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
@RequestMapping("/shopping-cart")
@RequiredArgsConstructor
public class ShoppingCartController {
    private final ShoppingCartService service;

    @PostMapping
    public Page<ShoppingCartDto> findAll(@RequestBody ShoppingCartFilter filter, Pageable pageable) {
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
