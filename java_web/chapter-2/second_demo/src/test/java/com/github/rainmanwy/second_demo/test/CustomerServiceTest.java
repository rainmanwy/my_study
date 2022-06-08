package com.github.rainmanwy.second_demo.test;

import com.github.rainmanwy.second_demo.model.Customer;
import com.github.rainmanwy.second_demo.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest() {
        this.customerService = new CustomerService();
    }

    @Before
    public void init() {

    }

    @Test
    public void getCustomerListTest() {
        List<Customer> customerList = this.customerService.getCustomerList(null);
        System.out.println(customerList);
        Assert.assertEquals(2, customerList.size());

        // name
        customerList = this.customerService.getCustomerList("er1");
        System.out.println(customerList);
        Assert.assertEquals(1, customerList.size());

        // contact
        customerList = this.customerService.getCustomerList("ack");
        System.out.println(customerList);
        Assert.assertEquals(1, customerList.size());
    }

    @Test
    public void getCustomerTest() {
        Customer customer = this.customerService.getCustomer(1);
        Assert.assertNotNull(customer);
    }

}
