package id.nurkholis.tirtamedical.domain.interactors.product;

import id.nurkholis.tirtamedical.domain.entities.CreateProduct;
import id.nurkholis.tirtamedical.domain.interactors.common.PageResult;
import id.nurkholis.tirtamedical.domain.entities.Product;

public interface ProductService {

    Product addProduct(CreateProduct product);
    PageResult<Product> searchProduct(ProductSearchRequest searchRequest);

}
