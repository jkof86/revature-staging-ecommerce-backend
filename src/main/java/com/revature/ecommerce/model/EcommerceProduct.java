package com.revature.ecommerce.model;

import java.util.List;
import javax.persistence.*;
import lombok.Data;

//we use @Entity to define this class as a table
@Entity
public @Data class EcommerceProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //specify this table will auto-generate ID
    private int productid;

    private String title;
    private String description;
    private String unitprice;
    private int quantity;
    private int inventory;

}
