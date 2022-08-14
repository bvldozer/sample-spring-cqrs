package id.nurkholis.tirtamedical.command.domain.interactors.product;

import id.nurkholis.tirtamedical.command.domain.entities.CreateProduct;
import id.nurkholis.tirtamedical.command.domain.entities.Product;
import id.nurkholis.tirtamedical.command.domain.interactors.common.PageResult;
import id.nurkholis.tirtamedical.command.domain.repositories.product.ProductQueryRepository;
import id.nurkholis.tirtamedical.command.domain.repositories.product.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(CreateProduct createProduct) {
        return productRepository.addProduct(createProduct);
    }

}
