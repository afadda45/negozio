package com.example.negozio2.mapping;

import com.example.negozio2.pojo.dto.CustomerDto;
import com.example.negozio2.pojo.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerEntity dtoToEntity(CustomerDto dto);


}
