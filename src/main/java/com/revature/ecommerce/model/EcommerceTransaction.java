package com.revature.ecommerce.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

//we use @Entity to define this class as a table
@Entity
public @Data class EcommerceTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //specify this table will auto-generate ID
    private int transactionid;

    private int userid;
    private int productid;

    @CreationTimestamp
    private LocalDateTime createdDateTime;
 
    // @UpdateTimestamp
    // private LocalDateTime updatedDateTime;

    private int quantity;

    @OneToMany()
    private List<EcommerceUser> users;
    @OneToMany()
    private List<EcommerceProduct> products;

}
