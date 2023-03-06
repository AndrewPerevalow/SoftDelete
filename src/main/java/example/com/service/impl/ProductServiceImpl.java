package example.com.service.impl;

import example.com.domain.ProductEntity;
import example.com.dto.ProductDto;
import example.com.filter.ProductFilter;
import example.com.repo.ProductRepository;
import example.com.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ModelMapper modelMapper;
    @Override
    public Page<ProductDto> findAll(ProductFilter filter, Pageable pageable) {
        Page<ProductEntity> entities = repository.findAll(filter.toSpecification(), pageable);
        List<ProductDto> dtos = entities.stream()
                .map(entity -> modelMapper.map(entity, ProductDto.class))
                .collect(Collectors.toList());
        return new PageImpl<>(dtos, entities.getPageable(), entities.getTotalElements());
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll(List<String> ids) {
        repository.deleteAllById(ids);
    }
}
