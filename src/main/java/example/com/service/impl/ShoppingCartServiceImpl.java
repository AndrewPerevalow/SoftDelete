package example.com.service.impl;

import example.com.domain.ShoppingCartEntity;
import example.com.dto.ShoppingCartDto;
import example.com.filter.ShoppingCartFilter;
import example.com.repo.ShoppingCartRepository;
import example.com.service.ShoppingCartService;
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
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository repository;
    private final ModelMapper modelMapper;
    @Override
    public Page<ShoppingCartDto> findAll(ShoppingCartFilter filter, Pageable pageable) {
        Page<ShoppingCartEntity> entities = repository.findAll(filter.toSpecification(), pageable);
        List<ShoppingCartDto> dtos = entities.stream()
                .map(entity -> modelMapper.map(entity, ShoppingCartDto.class))
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
