package hhplus.ecommerce.payment.application;

import hhplus.ecommerce.payment.domain.Payment;
import hhplus.ecommerce.payment.dto.request.PaymentReq;

public interface PaymentService {
    Payment pay(Long userId, PaymentReq req);
}
