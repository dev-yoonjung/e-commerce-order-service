package com.ecommerce.order_service.service;

import com.ecommerce.order_service.dto.RequestOrder;
import com.ecommerce.order_service.dto.ResponseOrder;
import com.ecommerce.order_service.exception.OrderNotFoundException;
import com.ecommerce.order_service.jpa.OrderEntity;
import com.ecommerce.order_service.jpa.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public ResponseOrder createOrder(RequestOrder requestOrder, String userId) {
        OrderEntity orderEntity = OrderEntity.of(requestOrder, userId);
        OrderEntity savedOrderEntity = orderRepository.save(orderEntity);

        return ResponseOrder.of(savedOrderEntity);
    }

    @Override
    public ResponseOrder getOrderByOrderId(String orderId) {
        return orderRepository.findByOrderId(orderId)
                .map(ResponseOrder::of)
                .orElseThrow(() -> new OrderNotFoundException(""));
    }

    @Override
    public List<ResponseOrder> getOrdersByUserId(String userId) {
        return IterableUtils
                .toList(orderRepository.findAll())
                .stream()
                .map(ResponseOrder::of)
                .toList();
    }

}
