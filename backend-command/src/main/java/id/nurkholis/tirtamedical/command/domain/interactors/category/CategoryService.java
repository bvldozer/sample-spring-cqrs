package id.nurkholis.tirtamedical.command.domain.interactors.category;

import id.nurkholis.tirtamedical.command.domain.entities.Category;
import org.springframework.transaction.annotation.Transactional;

public interface CategoryService {
    @Transactional
    Category addCategory(String categoryName);
}
