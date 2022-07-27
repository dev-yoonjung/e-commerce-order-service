package com.ecommerce.order_service.dto;

import com.ecommerce.order_service.jpa.OrderEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseOrder {

    private String productId;

    private Integer quantity;

    private Integer unitPrice;

    private Integer totalPrice;

    private Date createdAt;

    private String orderId;

    public static ResponseOrder of(OrderEntity entity) {
        return ResponseOrder.builder()
                .productId(entity.getProductId())
                .quantity(entity.getQuantity())
                .unitPrice(entity.getUnitPrice())
                .totalPrice(entity.getTotalPrice())
                .createdAt(entity.getCreatedAt())
                .orderId(entity.getOrderId())
                .build();
    }

}
