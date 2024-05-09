package hhplus.ecommerce.storage.orderitem;

import hhplus.ecommerce.domain.orderitem.OrderItem;
import hhplus.ecommerce.domain.orderitem.OrderItemRepository;
import hhplus.ecommerce.storage.order.OrderItemStatus;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemCoreRepository implements OrderItemRepository {
    private final OrderItemJpaRepository orderItemJpaRepository;

    public OrderItemCoreRepository(OrderItemJpaRepository orderItemJpaRepository) {
        this.orderItemJpaRepository = orderItemJpaRepository;
    }

//    @Override
//    public List<OrderItem> createOrderItem(List<OrderItemEntity> orderItemEntities) {
//        return orderItemJpaRepository.saveAll(orderItemEntities)
//                .stream().map(OrderItemEntity::toOrderItem)
//                .toList();
//    }

    @Override
    public List<OrderItem> findAllByOrderId(Long orderId) {
        return orderItemJpaRepository.findAllByOrderId(orderId).stream()
                .map(OrderItemEntity::toOrderItem)
                .toList();
    }

    @Override
    public void updateStatus(OrderItem item, OrderItemStatus orderItemStatus) {
        OrderItemEntity orderItemEntity = orderItemJpaRepository.findById(item.id())
                .orElseThrow(() -> new EntityNotFoundException("주문 아이템이 존재하지 않습니다. id - " + item.id()));

        orderItemEntity.updateStatus(orderItemStatus);
    }
}
