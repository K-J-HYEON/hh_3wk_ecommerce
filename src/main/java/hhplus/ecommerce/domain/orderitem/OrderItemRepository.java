package hhplus.ecommerce.domain.orderitem;

import hhplus.ecommerce.storage.order.OrderItemStatus;
import hhplus.ecommerce.storage.orderitem.OrderItemEntity;

import java.util.List;

public interface OrderItemRepository {
//    List<OrderItem> createOrderItem(List<OrderItemEntity> orderItemEntities);

    List<OrderItem> findAllByOrderId(Long orderId);

    void updateStatus(OrderItem item, OrderItemStatus orderItemStatus);
}
