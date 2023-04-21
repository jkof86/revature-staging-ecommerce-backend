package com.revature.ecommerce.service;

import java.util.List;

import com.revature.ecommerce.model.EcommerceProduct;
import com.revature.ecommerce.model.EcommerceTransaction;
import com.revature.ecommerce.model.EcommerceUser;

public interface EcommerceInterface {

    public EcommerceUser addUser(EcommerceUser u);
    public List<EcommerceUser> getUserList();
    public EcommerceUser getUserById(int id);
    public boolean loginUser(String email, String pass);
//----------------------------------------------------------------//
    public EcommerceProduct addProduct(EcommerceProduct p);
    public List<EcommerceProduct> getProductList();
    public EcommerceProduct getProductById(int id);
//----------------------------------------------------------------//
public EcommerceTransaction addTransaction(EcommerceTransaction t);
    public List<EcommerceTransaction> getTransactionList();
    public EcommerceTransaction getTransactionById(int id);
//----------------------------------------------------------------//
    //purchase method takes in a user and a list of products
    public EcommerceTransaction purchase(EcommerceUser u, int id);
    
}
