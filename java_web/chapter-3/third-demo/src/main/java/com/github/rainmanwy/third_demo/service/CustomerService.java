package com.github.rainmanwy.third_demo.service;

import com.github.rainmanwy.smart.annotation.Service;
import com.github.rainmanwy.smart.annotation.Transaction;
import com.github.rainmanwy.smart.helper.DatabaseHelper;
import com.github.rainmanwy.smart.helper.UploadHelper;
import com.github.rainmanwy.smart.util.StringUtil;
import com.github.rainmanwy.smart.bean.FileParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import com.github.rainmanwy.third_demo.model.Customer;

@Service
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
        LOGGER.debug(sql);
        List<Customer> customerList = DatabaseHelper.queryEntityList(Customer.class, sql);
        return customerList;
    }

    /**
     * get customer
     */
    public Customer getCustomer(long id) {
        String sql = "SELECT * FROM customer where id=" + id;
        Customer customer = DatabaseHelper.queryEntity(Customer.class, sql);
        return customer;
    }

    /**
     * create customer
     */
    @Transaction
    public boolean createCustomer(Map<String, Object> fieldMap, FileParam fileParam) {
        boolean result = DatabaseHelper.insertEntity(Customer.class, fieldMap);
        if (result) {
            LOGGER.info("Upload file: ", fileParam);
            UploadHelper.uploadFile("D:\\var\\", fileParam);
        }
        return true;
    }

    /**
     * edit customer
     */
    @Transaction
    public boolean editCustomer(long id, Map<String, Object> fieldMap) {
        DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
        return true;
    }

    /**
     * delete customer
     */
    @Transaction
    public boolean deleteCustomer(long id) {
        DatabaseHelper.deleteEntity(Customer.class, id);
        return true;
    }
}
