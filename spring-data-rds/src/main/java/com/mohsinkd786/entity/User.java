package com.mohsinkd786.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class User {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userId = UUID.randomUUID().toString();

    @Column(name = "uname")
    private String name;
    private String email;
    private String phone;

    private double salary;

    // uni directional relationship
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_address_id")
//    private Address address;

    // Only in case of bi directional
//    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
//    private Address address;
}
