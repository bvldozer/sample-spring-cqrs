package id.nurkholis.tirtamedical.domain.interactors.category;

import id.nurkholis.tirtamedical.domain.entities.Category;
import org.springframework.transaction.annotation.Transactional;

public interface CategoryService {
    @Transactional
    Category addCategory(String categoryName);
}
