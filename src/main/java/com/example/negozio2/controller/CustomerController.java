package com.example.negozio2.controller;

import com.example.negozio2.exceptions.AlreadyRegisteredException;
import com.example.negozio2.pojo.dto.CustomerDto;
import com.example.negozio2.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getCustomers(){
        ResponseEntity<?> response;
        try{
            response = new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id){
        ResponseEntity<?> response;
        try{
            response = new ResponseEntity<>(customerService.customerById(id), HttpStatus.OK);
        } catch (Exception e){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<?> postCustomer(@Valid @RequestBody CustomerDto dto){
        ResponseEntity<?> response;
        try{
            response = new ResponseEntity<>(customerService.addCustomer(dto), HttpStatus.OK);
        } catch (AlreadyRegisteredException e){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        ResponseEntity<?> response;
        try{
            response = new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
        } catch (Exception e){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return response;
    }
}
