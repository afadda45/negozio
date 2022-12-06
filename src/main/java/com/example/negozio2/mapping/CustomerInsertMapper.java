package com.example.negozio2.mapping;

import com.example.negozio2.pojo.entities.CustomerEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.TargetType;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerInsertMapper extends CustomerMapper{

    CustomerInsertMapper INSTANCE = Mappers.getMapper(CustomerInsertMapper.class);

    @AfterMapping
    default CustomerEntity map(@TargetType CustomerEntity customer){
        if(customer == null)
            return null;
        customer.setId(0L);
        return customer;
    }
}
