package com.ecommerce.order_service.service;

import com.ecommerce.order_service.dto.RequestOrder;
import com.ecommerce.order_service.dto.ResponseOrder;

import java.util.List;

public interface OrderService {

    ResponseOrder createOrder(RequestOrder requestOrder, String userId);

    ResponseOrder getOrderByOrderId(String orderId);

    List<ResponseOrder> getOrdersByUserId(String userId);

}
