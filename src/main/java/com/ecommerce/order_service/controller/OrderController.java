package com.ecommerce.order_service.controller;

import com.ecommerce.order_service.dto.RequestOrder;
import com.ecommerce.order_service.dto.ResponseOrder;
import com.ecommerce.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final Environment environment;

    private final OrderService orderService;

    @GetMapping("/orders/health-check")
    public String status() {
        return String.format(
                "It's working in order service on port %s",
                environment.getProperty("local.server.port"));
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<ResponseOrder> createOrder(@PathVariable String userId, @RequestBody RequestOrder requestOrder) {
        ResponseOrder responseOrder = orderService.createOrder(requestOrder, userId);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseOrder);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<ResponseOrder> getOrderByOrderId(@PathVariable String orderId) {
        return ResponseEntity.ok(orderService.getOrderByOrderId(orderId));
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<ResponseOrder>> getOrdersByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
    }

}
