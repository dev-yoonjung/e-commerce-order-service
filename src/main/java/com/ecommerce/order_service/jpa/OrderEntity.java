package com.ecommerce.order_service.jpa;

import com.ecommerce.order_service.dto.RequestOrder;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String productId;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer unitPrice;

    @Column(nullable = false)
    private Integer totalPrice;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false, unique = true)
    private String orderId;

    @Column(nullable = false, updatable = false, insertable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdAt;

    public static OrderEntity of(RequestOrder requestOrder, String userId) {
        Integer quantity = requestOrder.getQuantity();
        Integer unitPrice = requestOrder.getUnitPrice();

        return OrderEntity.builder()
                .orderId(UUID.randomUUID().toString())
                .productId(requestOrder.getProductId())
                .quantity(quantity)
                .unitPrice(unitPrice)
                .totalPrice(quantity * unitPrice)
                .userId(userId)
                .build();
    }

}
