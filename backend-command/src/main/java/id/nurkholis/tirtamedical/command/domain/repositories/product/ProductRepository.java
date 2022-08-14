package id.nurkholis.tirtamedical.command.domain.repositories.product;

import id.nurkholis.tirtamedical.command.domain.entities.CreateProduct;
import id.nurkholis.tirtamedical.command.domain.entities.Product;

import java.util.UUID;

public interface ProductRepository {

    Product addProduct(CreateProduct product);
    Product getProductById(UUID id);
}
