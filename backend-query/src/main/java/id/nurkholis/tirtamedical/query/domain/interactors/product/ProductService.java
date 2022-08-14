package id.nurkholis.tirtamedical.query.domain.interactors.product;

import id.nurkholis.tirtamedical.query.domain.entities.Product;
import id.nurkholis.tirtamedical.query.domain.interactors.common.PageResult;

public interface ProductService {

    PageResult<Product> searchProduct(ProductSearchRequest searchRequest);

}
