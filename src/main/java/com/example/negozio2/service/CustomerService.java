package com.example.negozio2.service;

import com.example.negozio2.exceptions.AlreadyRegisteredException;
import com.example.negozio2.exceptions.GenericException;
import com.example.negozio2.exceptions.NotFoundException;
import com.example.negozio2.mapping.CustomerInsertMapper;
import com.example.negozio2.mapping.CustomerMapper;
import com.example.negozio2.pojo.dto.CustomerDto;
import com.example.negozio2.pojo.entities.CustomerEntity;
import com.example.negozio2.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerEntity> getCustomers(){
        return customerRepository.findAll();
    }

    public CustomerEntity customerById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente con id " + id + " non trovato"));
    }

    public CustomerEntity addCustomer(CustomerDto dto){
        CustomerEntity customerEntity = null;
        String errorMessage;
        try {
            customerEntity = customerRepository.save(CustomerMapper.INSTANCE.dtoToEntity(dto));
        } catch (DataAccessException e) {
            if(customerRepository.findByEmail(dto.getEmail()).isPresent()){
                errorMessage = "Questa email è già registrata";
                throw new AlreadyRegisteredException(errorMessage);
            }
        } catch (Exception e) {
            throw new GenericException(e.getMessage());
        }
        return customerEntity;
    }

    public String deleteCustomer(Long id){
        CustomerEntity customerEntity = customerById(id);
        customerRepository.delete(customerEntity);
        return "Cliente eliminato";
    }

}
