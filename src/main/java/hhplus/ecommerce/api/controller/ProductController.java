package hhplus.ecommerce.api.controller;

import hhplus.ecommerce.api.dto.response.ProductDetailResponse;
import hhplus.ecommerce.api.dto.response.ProductListResponse;
import hhplus.ecommerce.api.dto.response.ProductSummaryResponse;
import hhplus.ecommerce.domain.product.Product;
import hhplus.ecommerce.domain.product.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/ecommerce/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Tag(name = "상품 목록 조회 API", description = "상품 목록을 조회하는 API입니다.")
    @GetMapping
    public ProductListResponse getProducts() {
        List<Product> products = productService.readProductInfo();

        List<ProductSummaryResponse> productSummaryResponseList = products.stream()
                .map(ProductSummaryResponse::from)
                .toList();
        return new ProductListResponse(productSummaryResponseList);
    }

    @Tag(name = "상품 세부 정보 조회 API", description = "상품 세부 정보를 조회하는 API입니다.")
    @GetMapping("/{productId}")
    public ProductDetailResponse getProduct(@PathVariable Long id) {
        Product product = productService.readProductInfoDetail(id);
        return ProductDetailResponse.from(product);
    }

    @Tag(name = "인기 상품 조회 API", description = "최근 3일간 가장 많이 팔린 상품 목록을 조회하는 API입니다.")
    @GetMapping("/popular")
    public ProductListResponse popularProducts() {
        List<Product> products = productService.readPopularProducts();

        List<ProductSummaryResponse> productSummaryResponseList = products.stream()
                .map(ProductSummaryResponse::from)
                .toList();
        return new ProductListResponse(productSummaryResponseList);
    }
}
