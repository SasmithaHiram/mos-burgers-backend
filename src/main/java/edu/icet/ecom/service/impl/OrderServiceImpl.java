package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Order;
import edu.icet.ecom.dto.OrderDetail;
import edu.icet.ecom.entity.OrderDetailEntity;
import edu.icet.ecom.entity.OrderEntity;
import edu.icet.ecom.entity.ProductEntity;
import edu.icet.ecom.repository.OrderDetailRepository;
import edu.icet.ecom.repository.OrderRepository;
import edu.icet.ecom.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class OrderServiceImpl implements OrderService {
    final OrderRepository orderRepository;
    final OrderDetailRepository orderDetailRepository;
    final ModelMapper mapper;

    @Transactional

    @Override
    public void placeOrder(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomerName(order.getCustomerName());
        orderEntity.setTotalAmount(order.getTotalAmount());

        OrderEntity save = orderRepository.save(orderEntity);

        List<OrderDetailEntity> orderDetailEntities = order.getOrderDetails().stream().map(orderDetail -> {
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setOrder(save);
            orderDetailEntity.setProduct(mapper.map(orderDetail.getProduct(), ProductEntity.class));
            orderDetailEntity.setQty(orderDetail.getQty());
            orderDetailEntity.setTotal(orderDetail.getTotal());
            return orderDetailEntity;
        }).collect(Collectors.toList());

        orderDetailRepository.saveAll(orderDetailEntities);
        save.setOrderDetails(orderDetailEntities);

    }

    @Override
    public List<OrderDetail> orderDetail() {
        return List.of();
    }

    @Override
    public Long getCount() {
        return 0L;
    }

    @Override
    public List<Order> getFiveOrders() {
        return List.of();
    }
}
