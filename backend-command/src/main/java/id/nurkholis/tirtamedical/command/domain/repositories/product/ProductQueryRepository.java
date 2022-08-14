package id.nurkholis.tirtamedical.command.domain.repositories.product;

import id.nurkholis.tirtamedical.command.domain.entities.Product;
import id.nurkholis.tirtamedical.command.domain.interactors.common.PageResult;
import id.nurkholis.tirtamedical.command.domain.interactors.product.ProductSearchRequest;

public interface ProductQueryRepository {

    void addProduct(Product product);
    PageResult<Product> searchProduct(ProductSearchRequest searchRequest);
}
