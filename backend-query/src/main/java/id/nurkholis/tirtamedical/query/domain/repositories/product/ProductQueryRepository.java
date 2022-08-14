package id.nurkholis.tirtamedical.query.domain.repositories.product;

import id.nurkholis.tirtamedical.query.domain.entities.Product;
import id.nurkholis.tirtamedical.query.domain.interactors.common.PageResult;
import id.nurkholis.tirtamedical.query.domain.interactors.product.ProductSearchRequest;

public interface ProductQueryRepository {

    void addProduct(Product product);
    PageResult<Product> searchProduct(ProductSearchRequest searchRequest);
}
