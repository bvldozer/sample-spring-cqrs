package id.nurkholis.tirtamedical.domain.interactors.product;

import id.nurkholis.tirtamedical.domain.entities.CreateProduct;
import id.nurkholis.tirtamedical.domain.entities.Product;
import id.nurkholis.tirtamedical.domain.interactors.common.PageResult;
import id.nurkholis.tirtamedical.domain.repositories.product.ProductRepository;
import id.nurkholis.tirtamedical.domain.repositories.product.ProductQueryRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductQueryRepository productQueryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductQueryRepository productQueryRepository) {
        this.productRepository = productRepository;
        this.productQueryRepository = productQueryRepository;
    }

    @Override
    public Product addProduct(CreateProduct createProduct) {
        return productRepository.addProduct(createProduct);
    }

    @Override
    public PageResult<Product> searchProduct(ProductSearchRequest searchRequest) {
        return productQueryRepository.searchProduct(searchRequest);
    }
}
