package hhplus.ecommerce.domain.product;

import hhplus.ecommerce.api.dto.request.OrderRequest;
import hhplus.ecommerce.storage.order.OrderStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ProductReader {
    private final ProductRepository productRepository;

    public ProductReader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> retrieveAll() {
        return productRepository.findAll();
    }

    public Product retrieveById(Long productId) {
        return productRepository.findById(productId);
    }

    public List<Product> retrieveAllByIds(List<Long> productIds) {
        return productRepository.findByIdIn(productIds);
    }

    public List<Product> retrievePopularProducts() {
        LocalDateTime endDate = LocalDateTime.now();
        LocalDateTime startDate = endDate.minusDays(3);
        Pageable topFive = PageRequest.of(0, 5);

        return productRepository.findTopSellingProducts(OrderStatus.PAID, startDate, endDate, topFive);
    }
}
