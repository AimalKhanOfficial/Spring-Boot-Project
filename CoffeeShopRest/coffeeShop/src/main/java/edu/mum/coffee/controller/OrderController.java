package edu.mum.coffee.controller;

import edu.mum.coffee.Utility.HttpCustomResponse;
import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.OrderlineService;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order/")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderlineService orderlineService;

    @Autowired
    HttpCustomResponse customResponse;

    @PostMapping("create")
    public HttpCustomResponse Create(@RequestBody Order order) {
        Order orderRes = orderService.save(order);
        if (orderRes != null) {
            customResponse.setResponseCode(200);
            customResponse.setResponseDescription("Success, Order was added with ID: " + orderRes.getId());
        } else {
            customResponse.setResponseCode(400);
            customResponse.setResponseDescription("The request did not execute as expected.");
        }
        return customResponse;
    }

    @PostMapping("createOrderline")
    public HttpCustomResponse CreateOrderLine(@RequestBody Orderline orderline) {
        Orderline orderLineRes = orderlineService.save(orderline);
        if (orderLineRes != null) {
            customResponse.setResponseCode(200);
            customResponse.setResponseDescription("Success, OrderLine was added with Order ID: " + orderLineRes.getOrder().getId());
        } else {
            customResponse.setResponseCode(400);
            customResponse.setResponseDescription("The request did not execute as expected.");
        }
        return customResponse;
    }

    @GetMapping("list")
    public List<Order> List() {
        return orderService.findAll();
    }
}
