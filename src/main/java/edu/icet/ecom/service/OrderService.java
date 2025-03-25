package edu.icet.ecom.service;

import edu.icet.ecom.dto.Order;
import edu.icet.ecom.dto.OrderDetail;

import java.util.List;

public interface OrderService {
    void placeOrder(Order order);
    List<OrderDetail> orderDetail();
}
