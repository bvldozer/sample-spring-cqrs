package id.nurkholis.tirtamedical.command.domain.repositories.category;

import id.nurkholis.tirtamedical.command.domain.entities.Category;

import java.util.UUID;

public interface CategoryRepository {
    Category addCategory(String categoryName);
    Category getCategoryById(UUID id);
}
