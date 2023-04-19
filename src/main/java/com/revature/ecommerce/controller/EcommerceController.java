package com.revature.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ecommerce.model.EcommerceProduct;
import com.revature.ecommerce.model.EcommerceTransaction;
import com.revature.ecommerce.model.EcommerceUser;
import com.revature.ecommerce.service.EcommerceInterface;
import com.revature.ecommerce.service.EcommerceService;

@RestController
@RequestMapping()
public class EcommerceController {

    private EcommerceService serv;

    public EcommerceController(EcommerceService serv) {
        this.serv = serv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/register")
    public EcommerceUser addUser(@RequestBody EcommerceUser user) {
        return serv.addUser(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/all")
    public List<EcommerceUser> getUserList() {
        return serv.getUserList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    public EcommerceUser getUserById(@PathVariable(name = "id", required = true) int id) {
        return serv.getUserById(id);
    }

    // we pass email and pass as path variables
    @RequestMapping(method = RequestMethod.GET, value = "/user/login/{email}&{pass}")
    public boolean getEmployeeById(@PathVariable String email, @PathVariable String pass) {
        return serv.loginUser(email, pass);
    }

    // -----------------------------------------------------------------------------------------------

    @RequestMapping(method = RequestMethod.GET, value = "/product/all")
    public List<EcommerceProduct> getProductList() {
        return serv.getProductList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}")
    public EcommerceProduct getProductById(@PathVariable(name = "id", required = true) int id) {
        return serv.getProductById(id);
    }
    // -----------------------------------------------------------------------------------------------

    @RequestMapping(method = RequestMethod.GET, value = "/transaction/all")
    public List<EcommerceTransaction> getTransactionList() {
        return serv.getTransactionList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/transaction/{id}")
    public EcommerceTransaction getTransactionById(@PathVariable(name = "id", required = true) int id) {
        return serv.getTransactionById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cart")
    public boolean purchase(@RequestBody EcommerceUser u, EcommerceTransaction t, List<EcommerceProduct> productList) {
        return serv.purchase(u, t, productList);
    }
}