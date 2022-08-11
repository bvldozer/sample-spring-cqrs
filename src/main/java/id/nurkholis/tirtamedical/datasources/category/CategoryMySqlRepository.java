package id.nurkholis.tirtamedical.datasources.category;

import id.nurkholis.tirtamedical.domain.entities.Category;
import id.nurkholis.tirtamedical.domain.repositories.category.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Repository
public class CategoryMySqlRepository implements CategoryRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Category addCategory(String categoryName) {
        CategoryEntity entity = new CategoryEntity();
        entity.setName(categoryName);
        entity = em.merge(entity);
        Category category = Category.builder().build();
        BeanUtils.copyProperties(entity, category);
        category.setCreatedAt(entity.getCreatedAt().toInstant().toEpochMilli());
        return category;
    }

    @Override
    public Category getCategoryById(UUID id) {
        CategoryEntity entity = em.find(CategoryEntity.class, id);
        if(entity == null) {
            throw new IllegalArgumentException("category not found");
        }
        Category category = Category.builder().build();
        BeanUtils.copyProperties(entity, category);
        return category;
    }
}
