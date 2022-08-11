package id.nurkholis.tirtamedical.domain.repositories.product;

import id.nurkholis.tirtamedical.domain.entities.Product;
import id.nurkholis.tirtamedical.domain.interactors.common.PageResult;
import id.nurkholis.tirtamedical.domain.interactors.product.ProductSearchRequest;

public interface ProductQueryRepository {

    void addProduct(Product product);
    PageResult<Product> searchProduct(ProductSearchRequest searchRequest);
}
