package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Order;
import edu.icet.ecom.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/place-order")
    public void placeOrder(@RequestBody Order order) {
        orderService.placeOrder(order);
    }

    @GetMapping("/get-All")
    public List<Order> getAll() {
        return orderService.getAll();
    }

}
