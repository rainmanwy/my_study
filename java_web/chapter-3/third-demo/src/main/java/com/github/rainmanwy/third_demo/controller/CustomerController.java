package com.github.rainmanwy.third_demo.controller;

import com.github.rainmanwy.smart.annotation.Action;
import com.github.rainmanwy.smart.annotation.Controller;
import com.github.rainmanwy.smart.annotation.Inject;
import com.github.rainmanwy.smart.bean.Data;
import com.github.rainmanwy.smart.bean.Param;
import com.github.rainmanwy.smart.bean.FileParam;
import com.github.rainmanwy.smart.bean.View;
import com.github.rainmanwy.third_demo.model.Customer;
import com.github.rainmanwy.third_demo.service.CustomerService;

import java.util.List;
import java.util.Map;


@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @Action(value = "get:/customer")
    public View getCustomers() {
        List<Customer> customerList = customerService.getCustomerList(null);
        View view = new View("customer.jsp");
        view.addModel("customerList", customerList);
        return view;
    }

    @Action("get:/customer_show")
    public View show(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_show.jsp").addModel("customer", customer);
    }

    @Action("get:/customer_create")
    public View create() {
        return new View("customer_create.jsp");
    }

    @Action("post:/customer_create")
    public Data createSubmit(Param param) {
        FileParam fileParam = param.getFile("photo");
        Map<String, Object> fieldMap = param.getFieldMap();
        boolean result = customerService.createCustomer(fieldMap, fileParam);
        return new Data(result);
    }

    @Action("get:/customer_edit")
    public View edit(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_edit.jsp").addModel("customer", customer);
    }

    @Action("put:/customer_edit")
    public Data editSubmit(Param param) {
        long id = param.getLong("id");
        Map<String, Object> fieldMap = param.getFieldMap();
        boolean result = customerService.editCustomer(id, fieldMap);
        return new Data(result);
    }

    @Action("delete:/customer_delete")
    public Data delete(Param param) {
        long id = param.getLong("id");
        boolean result = customerService.deleteCustomer(id);
        return new Data(result);
    }
}
