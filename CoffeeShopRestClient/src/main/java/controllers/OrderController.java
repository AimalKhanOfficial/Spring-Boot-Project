package controllers;

import dao.OrdersDao;
import dao.PersonsDao;
import dao.ProductsDao;
import domain.Order;
import domain.Orderline;
import domain.Person;
import domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    List<Product> products = new ArrayList<>();

    @GetMapping("/orders")
    public String orders(Model model) {
        OrdersDao ordersDao = new OrdersDao();
        model.addAttribute("orders", ordersDao.getAllOrders());
        return "orders";
    }

    @PostMapping("createOrder")
    public String createOrder(HttpServletRequest request){

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
        Date orderDate = null;
        try {
            orderDate = sdf.parse(request.getParameter("txtDT").toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        OrdersDao ordersDao = new OrdersDao();

        Order order = new Order();
        order.setPerson(new PersonsDao().getPersonById(request.getParameter("ddlPerson").toString()));
        order.setOrderDate(orderDate);

        Order orderRes = ordersDao.createOrder(order);

        for(Product product : products){
            Orderline orderline = new Orderline();
            orderline.setOrder(orderRes);
            orderline.setQuantity(1);
            orderline.setProduct(product);
            ordersDao.createOrderLine(orderline);
        }
        return "redirect:/orders";
    }

    @GetMapping("/create")
    public String create(Model model, HttpServletRequest request) {
        ProductsDao productsDao = new ProductsDao();
        PersonsDao personsDao = new PersonsDao();
        model.addAttribute("persons", personsDao.getAllPersons());
        model.addAttribute("products", productsDao.getAllProducts());
        request.removeAttribute("productsOrderline");
        return "createOrder";
    }

    @PostMapping(value = "/addProductToCart", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addProductToCart(@RequestBody Product product, HttpServletRequest request){
        try{
            if(request.getSession().getAttribute("productsOrderline") != null){
                products = (List<Product>) request.getSession().getAttribute("productsOrderline");
            }
            products.add(product);
            request.getSession().setAttribute("productsOrderline", products);
        }
        catch(Exception ex){
            System.out.println("Issue");
        }
    }
}
