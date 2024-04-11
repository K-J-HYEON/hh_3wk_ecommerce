package hhplus.ecommerce.domain.product;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductReader productReader;
    public ProductServiceImpl(ProductReader productReader) {
        this.productReader = productReader;
    }

    @Override
    public List<Product> readProductInfo() {
        return productReader.retrieveAll();
    }

    @Override
    public Product readProductInfoDetail(Long productId) {
        return productReader.retrieveById(productId);
    }

    @Override
    public List<Product> readPopularProduct() {
        return productReader.readPopularSellingProducts();
    }
}