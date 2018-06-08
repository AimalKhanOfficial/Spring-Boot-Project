package controllers;

import dao.OrdersDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @GetMapping("/orders")
    public String orders(Model model) {
        OrdersDao ordersDao = new OrdersDao();
        model.addAttribute("orders", ordersDao.getAllOrders());
        return "orders";
    }
}
