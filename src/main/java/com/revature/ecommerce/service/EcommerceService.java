package com.revature.ecommerce.service;

import java.util.List;
import java.util.Date;
import java.time.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.ecommerce.dao.ProductRepo;
import com.revature.ecommerce.dao.TransactionRepo;
import com.revature.ecommerce.dao.UserRepo;
import com.revature.ecommerce.model.EcommerceProduct;
import com.revature.ecommerce.model.EcommerceTransaction;
import com.revature.ecommerce.model.EcommerceUser;

@Service
public class EcommerceService implements EcommerceInterface {

    private UserRepo urepo;
    private ProductRepo prepo;
    private TransactionRepo trepo;

    public EcommerceService(UserRepo urepo, ProductRepo prepo, TransactionRepo trepo) {
        this.urepo = urepo;
        this.prepo = prepo;
        this.trepo = trepo;
    }

    @Override
    public EcommerceUser addUser(EcommerceUser u) {

        // first we generate a list of all users
        List<EcommerceUser> userList = getUserList();

        // we iterate through the list and check for a matching email
        for (EcommerceUser user1 : userList) {
            // if we find a match, we return null (account already exists)
            if (user1.getEmail().equalsIgnoreCase(u.getEmail())) {
                return null;
            }

        }

        // otherwise we register the new user
        // we save the user to our db
        return urepo.save(u);
    }

    @Override
    public List<EcommerceUser> getUserList() {
        // we print a user list
        return urepo.findAll();
    }

    @Override
    public EcommerceUser getUserById(int id) {
        // we generate a list of all users
        List<EcommerceUser> userList = urepo.findAll();

        // we iterate through the list and find the correct id
        // **not optimized for efficiency** O(n)
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserid() == id) {
                return userList.get(i);
            }
        }
        // if the employee id isn't found, we return null
        return null;

    }

    @Override
    public boolean loginUser(String email, String pass) {
        // we generate a list of all users
        List<EcommerceUser> userList = urepo.findAll();

        // we iterate through the list and check for validation
        // **not optimized for efficiency** O(n)

        for (int i = 0; i < userList.size(); i++) {

            // then we validate the email and password
            if (email.equals(userList.get(i).getEmail()) &&
                    pass.equals(userList.get(i).getPassword())) {
                return true;
            }
        }
        // if there is no email/pass match we return false
        return false;
    }

    // -------------------------------------------------------------------------------------------------//
    @Override
    public EcommerceProduct addProduct(EcommerceProduct p) {
        // then we save the product to our db
        return prepo.save(p);
    }

    @Override
    public List<EcommerceProduct> getProductList() {
        return prepo.findAll();
    }

    @Override
    public EcommerceProduct getProductById(int id) {
        // we generate a list of all products
        List<EcommerceProduct> productList = prepo.findAll();

        // we iterate through the list and find the correct id
        // **not optimized for efficiency** O(n)
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductid() == id) {
                return productList.get(i);
            }
        }
        // if the product id isn't found, we return null
        return null;
    }

    // -------------------------------------------------------------------------------------------------//
    @Override
    public EcommerceTransaction addTransaction(EcommerceTransaction t) {
        // first we search for the transaction by id
        trepo.findById(t.getTransactionid());

        // then we save the transaction to our db
        return trepo.save(t);
    }

    @Override
    public List<EcommerceTransaction> getTransactionList() {
        return trepo.findAll();
    }

    @Override
    public EcommerceTransaction getTransactionById(int id) {
        // we generate a list of all products
        List<EcommerceTransaction> transactionList = trepo.findAll();

        // we iterate through the list and find the correct id
        // **not optimized for efficiency** O(n)
        for (int i = 0; i < transactionList.size(); i++) {
            if (transactionList.get(i).getTransactionid() == id) {
                return transactionList.get(i);
            }
        }
        // if the transaction id isn't found, we return null
        return null;
    }

    // -------------------------------------------------------------------------------------------------//

    @Override
    public EcommerceTransaction purchase(EcommerceUser u, EcommerceTransaction t, int id) {

        // we find the product in our DB
        EcommerceProduct product = prepo.findById(id).get();

        // we check for available units according to inventory count
        // if the operation puts the inventory negative we dont complete the transaction
        // therefore we return null
        if ((product.getInventory() <= 0)) {
            return null;
        }
        // after confirming the product is available
        // we log the transaction by creating the object and returning it

        t.setProductid(product.getProductid());
        t.setUserid(u.getUserid());
        //t.setDate(LocalDateTime.now());
        t.setQuantity(product.getQuantity());

        // if we get this far
        // we decrement inventory
        product.setInventory(product.getInventory() - 1);

        // we complete and log the transaction
        return trepo.save(t);

    }
}
