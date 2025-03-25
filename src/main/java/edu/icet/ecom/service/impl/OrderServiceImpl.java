package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Order;
import edu.icet.ecom.dto.OrderDetail;
import edu.icet.ecom.repository.OrderDetailRepository;
import edu.icet.ecom.repository.OrderRepository;
import edu.icet.ecom.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class OrderServiceImpl implements OrderService {
    final private OrderRepository orderRepository;
    final private OrderDetailRepository orderDetailRepository;
    final private ModelMapper mapper;

    @Transactional

    @Override
    public void placeOrder(Order order) {

    }

    @Override
    public List<OrderDetail> orderDetail() {
        return List.of();
    }
}
