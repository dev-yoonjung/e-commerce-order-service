package com.ecommerce.order_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestOrder {

    private String productId;

    private Integer quantity;

    private Integer unitPrice;

}
