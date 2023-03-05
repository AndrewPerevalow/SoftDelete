package example.com.service.impl;

import example.com.domain.CustomerEntity;
import example.com.dto.CustomerDto;
import example.com.filter.CustomerFilter;
import example.com.repo.CustomerRepository;
import example.com.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper modelMapper;
    @Override
    public Page<CustomerDto> findAll(CustomerFilter filter, Pageable pageable) {
        Page<CustomerEntity> entities = repository.findAll(filter.toSpecification(), pageable);
        List<CustomerDto> dtos = entities.stream()
                .map(entity -> modelMapper.map(entity, CustomerDto.class))
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
