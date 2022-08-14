package id.nurkholis.tirtamedical.command.domain.interactors.category;

import id.nurkholis.tirtamedical.command.domain.entities.Category;
import id.nurkholis.tirtamedical.command.domain.repositories.category.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category addCategory(String categoryName) {
        return categoryRepository.addCategory(categoryName);
    }
}
