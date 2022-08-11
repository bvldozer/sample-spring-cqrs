package id.nurkholis.tirtamedical.domain.repositories.product;

import id.nurkholis.tirtamedical.domain.entities.CreateProduct;
import id.nurkholis.tirtamedical.domain.entities.Product;

import java.util.UUID;

public interface ProductRepository {

    Product addProduct(CreateProduct product);
    Product getProductById(UUID id);
}
