package hhplus.ecommerce.domain.order;

import hhplus.ecommerce.api.dto.request.OrderRequest;
import hhplus.ecommerce.domain.user.User;
import hhplus.ecommerce.storage.order.OrderStatus;

public interface OrderRepository {
    Order order(User user, OrderRequest request);

    Order updateStatus(Order order, OrderStatus orderStatus);

    Order findById(Long orderId);
}
