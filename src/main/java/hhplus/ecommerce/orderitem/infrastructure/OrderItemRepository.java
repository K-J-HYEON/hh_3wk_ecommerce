package hhplus.ecommerce.orderitem.infrastructure;

import hhplus.ecommerce.orderitem.entity.OrderItemEntity;
import hhplus.ecommerce.orderitem.domain.OrderItem;

import java.util.List;

public interface OrderItemRepository {
    List<OrderItem> createOrderItem(List<OrderItemEntity> orderItemEntities);
}