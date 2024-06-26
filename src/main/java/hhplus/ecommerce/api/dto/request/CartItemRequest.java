package hhplus.ecommerce.api.dto.request;

import hhplus.ecommerce.domain.cart.cartitem.NewCartItem;
import java.util.ArrayList;
import java.util.List;

public record CartItemRequest(List<CartItem> cartItems) {
    public record CartItem(Long productId,
                           Long quantity) {
    }

    public List<NewCartItem> toNewCartItem() {
        List<NewCartItem> newCartItems = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            if (cartItem.quantity <= 0) {
                throw new IllegalArgumentException("0 이하 수량은 장바구니에 추가할 수 없습니다.");
            }

            newCartItems.add(new NewCartItem(cartItem.productId, cartItem.quantity));
        }
        return newCartItems;
    }
}