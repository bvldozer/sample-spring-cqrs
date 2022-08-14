package id.nurkholis.tirtamedical.command.domain.interactors.product;

import id.nurkholis.tirtamedical.command.domain.entities.CreateProduct;
import id.nurkholis.tirtamedical.command.domain.entities.Product;
import id.nurkholis.tirtamedical.command.domain.interactors.common.PageResult;

public interface ProductService {

    Product addProduct(CreateProduct product);

}
