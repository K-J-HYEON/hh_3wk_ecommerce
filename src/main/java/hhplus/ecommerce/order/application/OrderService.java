package hhplus.ecommerce.order.application;

import hhplus.ecommerce.order.domain.Order;
import hhplus.ecommerce.order.dto.request.OrderReq;

public interface OrderService {
    Order order(Long userId, OrderReq req);
}