package com.example.negozio2.repositories;

import com.example.negozio2.pojo.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Query(value = "SELECT * FROM customers WHERE email = ?1", nativeQuery = true)
    Optional<CustomerEntity> findByEmail(String email);
}
