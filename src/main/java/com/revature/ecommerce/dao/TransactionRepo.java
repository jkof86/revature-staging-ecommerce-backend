package com.revature.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.ecommerce.model.EcommerceTransaction;
import com.revature.ecommerce.model.EcommerceUser;

@Repository
public interface TransactionRepo extends JpaRepository<EcommerceTransaction, Integer>{
    /*
       Repo CRUD operations
        .save(),
        .delete(),
        .update(),
        etc.
    */

    //Spring data will automatically implment this abstract method for you as long as you follow their keywords
    //public List<EcommerceUser> findByName(String name);
}