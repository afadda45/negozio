package com.example.negozio2.mapping;

import com.example.negozio2.pojo.entities.CustomerEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.TargetType;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerGenericMapper extends CustomerMapper{

    CustomerGenericMapper INSTANCE = Mappers.getMapper(CustomerGenericMapper.class);

    @AfterMapping
    default CustomerEntity map(@TargetType CustomerEntity customer){
        if(customer == null)
            return null;
        if(customer.getId() == null)
            customer.setId(0L);
        return customer;
    }
}
