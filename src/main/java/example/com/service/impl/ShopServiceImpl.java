package example.com.service.impl;

import example.com.domain.ShopEntity;
import example.com.dto.ShopDto;
import example.com.filter.ShopFilter;
import example.com.repo.ShopRepository;
import example.com.service.ShopService;
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
public class ShopServiceImpl implements ShopService {
    private final ShopRepository repository;
    private final ModelMapper modelMapper;
    @Override
    public Page<ShopDto> findAll(ShopFilter filter, Pageable pageable) {
        Page<ShopEntity> entities = repository.findAll(filter.toSpecification(), pageable);
        List<ShopDto> dtos = entities.stream()
                .map(entity -> modelMapper.map(entity, ShopDto.class))
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
