package com.github.rainmanwy.second_demo.controller;

import com.github.rainmanwy.second_demo.model.Customer;
import com.github.rainmanwy.second_demo.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customerList = customerService.getCustomerList(null);
        req.setAttribute("customerList", customerList);
        req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req, resp);
    }
}
