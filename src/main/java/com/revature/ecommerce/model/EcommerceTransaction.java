package com.revature.ecommerce.model;

import java.util.List;
import javax.persistence.*;
import lombok.Data;

//we use @Entity to define this class as a table
@Entity
public @Data class EcommerceTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //specify this table will auto-generate ID
    private int transactionid;

    private String userid;
    private String productid;
    private String date;
    private int quantity;
    private double totalsale;

    @OneToMany()
    private List<EcommerceUser> users;
    @OneToMany()
    private List<EcommerceProduct> products;

}
