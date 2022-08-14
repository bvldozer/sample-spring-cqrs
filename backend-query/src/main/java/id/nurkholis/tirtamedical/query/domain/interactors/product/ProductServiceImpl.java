package id.nurkholis.tirtamedical.query.domain.interactors.product;

import id.nurkholis.tirtamedical.query.domain.entities.Product;
import id.nurkholis.tirtamedical.query.domain.interactors.common.PageResult;
import id.nurkholis.tirtamedical.query.domain.repositories.product.ProductQueryRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductQueryRepository productQueryRepository;

    public ProductServiceImpl(ProductQueryRepository productQueryRepository) {
        this.productQueryRepository = productQueryRepository;
    }

    @Override
    public PageResult<Product> searchProduct(ProductSearchRequest searchRequest) {
        return productQueryRepository.searchProduct(searchRequest);
    }
}
