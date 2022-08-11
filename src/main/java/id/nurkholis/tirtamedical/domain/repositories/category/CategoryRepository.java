package id.nurkholis.tirtamedical.domain.repositories.category;

import id.nurkholis.tirtamedical.domain.entities.Category;

import java.util.UUID;

public interface CategoryRepository {
    Category addCategory(String categoryName);
    Category getCategoryById(UUID id);
}
