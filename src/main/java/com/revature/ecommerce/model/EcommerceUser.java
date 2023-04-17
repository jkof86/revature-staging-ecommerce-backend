package com.revature.ecommerce.model;

import java.util.List;
import javax.persistence.*;
import lombok.Data;

//we use @Entity to define this class as a table
@Entity
public @Data class EcommerceUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //specify this table will auto-generate ID
    private int userid;

    private String fname;
    private String lname;
    private String address;
    private String email;
    private String password;
    private int role;

    @ManyToMany()
    private List<EcommerceProduct> products;
    
    
}
