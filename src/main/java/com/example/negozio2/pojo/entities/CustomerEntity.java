package com.example.negozio2.pojo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customers")
@SequenceGenerator(name="customer_seq", initialValue=1, allocationSize=1)
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "customer_seq")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;
}
