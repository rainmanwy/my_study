package com.github.rainmanwy.third_demo.controller;

import com.github.rainmanwy.smart.annotation.Action;
import com.github.rainmanwy.smart.annotation.Controller;
import com.github.rainmanwy.smart.annotation.Inject;
import com.github.rainmanwy.smart.bean.Param;
import com.github.rainmanwy.smart.bean.View;
import com.github.rainmanwy.third_demo.model.Customer;
import com.github.rainmanwy.third_demo.service.CustomerService;

import java.util.List;


@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @Action(value = "get:/customer")
    public View getCustomers(Param param) {
        List<Customer> customerList = customerService.getCustomerList(null);
        View view = new View("customer.jsp");
        view.addModel("customerList", customerList);
        return view;
    }
}
