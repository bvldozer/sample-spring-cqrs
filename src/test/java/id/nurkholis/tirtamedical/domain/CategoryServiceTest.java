package id.nurkholis.tirtamedical.domain;

import id.nurkholis.tirtamedical.domain.entities.Category;
import id.nurkholis.tirtamedical.domain.interactors.category.CategoryService;
import id.nurkholis.tirtamedical.domain.interactors.category.CategoryServiceImpl;
import id.nurkholis.tirtamedical.domain.repositories.category.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class CategoryServiceTest {

    private CategoryRepository categoryRepository;

    private CategoryService categoryService;

    private Category category = Category.builder()
            .name("Category Name")
            .build();

    @BeforeEach
    public void before() {
        categoryRepository = mock(CategoryRepository.class);

        when(categoryRepository.addCategory("Category Name")).thenReturn(category);

        categoryService = new CategoryServiceImpl(categoryRepository);
    }

    @Test
    public void givenNewCategoryName_whenAddCategory_thenCorrect() {
        final Category result = categoryService.addCategory("Category Name");

        verify(categoryRepository, times(1)).addCategory("Category Name");

        assertThat(result, is(notNullValue()));
        assertThat(result.getName(), is("Category Name"));
    }
}
