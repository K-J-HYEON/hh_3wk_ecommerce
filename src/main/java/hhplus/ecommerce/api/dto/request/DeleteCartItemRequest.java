package hhplus.ecommerce.api.dto.request;

import java.util.List;

public record DeleteCartItemRequest(List<Long> cartItemIdList) {

}
