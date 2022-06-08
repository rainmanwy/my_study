package com.github.rainmanwy.second_demo.service;

import com.github.rainmanwy.second_demo.helper.DatabaseHelper;
import com.github.rainmanwy.second_demo.model.Customer;
import com.github.rainmanwy.second_demo.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class CustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    /**
    * get customer list
    */
    public List<Customer> getCustomerList(String keyword) {
        String sql = "SELECT * FROM customer";
        if (StringUtil.isNotEmpty(keyword)) {
            sql = sql + " " + " WHERE name LIKE '%" + keyword+ "%' or contact LIKE '%" + keyword+ "%'";
        }
        List<Customer> customerList = DatabaseHelper.queryEntityList(Customer.class, sql);
        return customerList;
    }

    /**
     * get customer
     */
    public Customer getCustomer(long id) {
        return null;
    }

    /**
     * create customer
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return false;
    }

    /**
     * edit customer
     */
    public boolean editCustomer(long id, Map<String, Object> fieldMap) {
        return false;
    }

    /**
     * delete customer
     */
    public boolean deleteCustomer(long id) {
        return false;
    }
}
