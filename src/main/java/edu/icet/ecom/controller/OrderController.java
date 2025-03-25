package edu.icet.ecom.controller;

import edu.icet.ecom.dto.Order;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@CrossOrigin
public class OrderController {
   // private final OrderService service;
    private final ModelMapper mapper;
    public void addOrder(Order order) {

    }
}
