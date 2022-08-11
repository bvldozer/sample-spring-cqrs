package id.nurkholis.tirtamedical.datasources.product;

import id.nurkholis.tirtamedical.datasources.category.CategoryEntity;
import id.nurkholis.tirtamedical.domain.entities.Category;
import id.nurkholis.tirtamedical.domain.entities.CreateProduct;
import id.nurkholis.tirtamedical.domain.entities.Product;
import id.nurkholis.tirtamedical.domain.repositories.product.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Repository
public class ProductMySqlRepository implements ProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Product addProduct(CreateProduct createProduct) {
        CategoryEntity categoryEntity = em.find(CategoryEntity.class, createProduct.getCategoryId());
        if(categoryEntity == null) {
            throw new IllegalArgumentException("category not found");
        }
        ProductEntity entity = new ProductEntity();
        entity.setSku(createProduct.getSku());
        entity.setName(createProduct.getName());
        entity.setPrice(createProduct.getPrice());
        entity.setStock(createProduct.getStock());
        entity.setCategory(categoryEntity);
        entity = em.merge(entity);
        Product product = Product.builder().build();
        BeanUtils.copyProperties(entity, product);
        Category category = Category.builder().build();
        BeanUtils.copyProperties(categoryEntity, category);
        category.setCreatedAt(categoryEntity.getCreatedAt().toInstant().toEpochMilli());
        product.setCategory(category);
        product.setCreatedAt(entity.getCreatedAt().toInstant().toEpochMilli());
        return product;
    }

    @Override
    public Product getProductById(UUID id) {
        ProductEntity entity = em.find(ProductEntity.class, id);
        if(entity == null) {
            throw new IllegalArgumentException("product not found");
        }
        Product product = Product.builder().build();
        BeanUtils.copyProperties(entity, product);
        return product;
    }
}
