package hhplus.ecommerce.storage.orderitem;

import hhplus.ecommerce.config.BaseTimeEntity;
import hhplus.ecommerce.domain.orderitem.OrderItem;
import hhplus.ecommerce.storage.order.OrderItemStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_items")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItemEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "productId")
    private Long productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "unitPrice")
    private Long unitPrice;

    @Column(name = "totalPrice")
    private Long totalPrice;

    @Column(name = "quantity")
    private Long quantity;

    @Enumerated(EnumType.STRING)
    private OrderItemStatus status;

    public Long getId() {
        return id;
    }

    public OrderItemEntity(
            Long orderId,
            Long productId,
            String productName,
            Long unitPrice,
            Long totalPrice,
            Long quantity,
            OrderItemStatus status) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.status = status;
    }

    public OrderItem toOrderItem() {
        return new OrderItem(
                getId(),
                orderId,
                productId,
                productName,
                unitPrice,
                totalPrice,
                quantity,
                status.toString()
        );
    }

    public void updateStatus(OrderItemStatus status) {
        this.status= status;
    }
}
