package com.github.rainmanwy.third_demo.test;

import com.github.rainmanwy.smart.helper.DatabaseHelper;
import com.github.rainmanwy.third_demo.model.Customer;
import com.github.rainmanwy.third_demo.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomerServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceTest.class);

    private final CustomerService customerService;

    public CustomerServiceTest() {
        this.customerService = new CustomerService();
    }

    @Before
    public void init() {
        String sqlFile = "sql/insert_customer.sql";
        DatabaseHelper.executeSqlFile(sqlFile);
    }

    @Test
    public void getCustomerListTest() {
        List<Customer> customerList = this.customerService.getCustomerList(null);
        LOGGER.debug(customerList.toString());
        Assert.assertEquals(2, customerList.size());

        // name
        customerList = this.customerService.getCustomerList("er1");
        LOGGER.info(customerList.toString());
        Assert.assertEquals(1, customerList.size());

        // contact
        customerList = this.customerService.getCustomerList("ack");
        LOGGER.info(customerList.toString());
        Assert.assertEquals(1, customerList.size());
    }

    @Test
    public void deleteCustomer() {
        boolean result = customerService.deleteCustomer(1);
        Assert.assertTrue(result);

        List<Customer> customerList = this.customerService.getCustomerList(null);
        LOGGER.debug(customerList.toString());
        Assert.assertEquals(1, customerList.size());
    }

    @Test
    public void getCustomerTest() {
        Customer customer = this.customerService.getCustomer(1);
        Assert.assertNotNull(customer);
    }

    @Test
    public void editCustomerTest() {
        Map<String, Object> mapFields = new HashMap<>();
        mapFields.put("name", "changed");
        boolean result = customerService.editCustomer(1, mapFields);
        Assert.assertTrue(result);
        Customer customer = customerService.getCustomer(1);
        Assert.assertEquals(customer.getName(), "changed");
    }

    @Test
    public void insertCustomerTest() {
        Map<String, Object> mapFields = new HashMap<>();
        mapFields.put("name", "new");
        mapFields.put("contact", "new_contact");
        mapFields.put("telephone", "1");
        mapFields.put("email", "1@mail.com");
        mapFields.put("remark", null);

        boolean result = customerService.createCustomer(mapFields, null);
        Assert.assertTrue(result);

        List<Customer> customerList = this.customerService.getCustomerList(null);
        LOGGER.debug(customerList.toString());
        Assert.assertEquals(3, customerList.size());
    }

}
