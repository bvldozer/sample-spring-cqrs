package id.nurkholis.tirtamedical.domain;

import id.nurkholis.tirtamedical.domain.entities.Category;
import id.nurkholis.tirtamedical.domain.entities.CreateProduct;
import id.nurkholis.tirtamedical.domain.entities.Product;
import id.nurkholis.tirtamedical.domain.interactors.common.PageResult;
import id.nurkholis.tirtamedical.domain.interactors.product.ProductSearchRequest;
import id.nurkholis.tirtamedical.domain.interactors.product.ProductService;
import id.nurkholis.tirtamedical.domain.interactors.product.ProductServiceImpl;
import id.nurkholis.tirtamedical.domain.repositories.product.ProductQueryRepository;
import id.nurkholis.tirtamedical.domain.repositories.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ProductServiceTest {

    private ProductRepository productRepository;
    private ProductQueryRepository productQueryRepository;

    private ProductService productService;

    private CreateProduct createProduct = CreateProduct.builder()
            .sku("SKU")
            .name("Product Name")
            .price(BigDecimal.valueOf(100000))
            .stock(100l)
            .categoryId(UUID.fromString("f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454"))
            .build();

    private Product product = Product.builder()
            .sku("SKU")
            .name("Product Name")
            .price(BigDecimal.valueOf(100000))
            .stock(100l)
            .category(Category.builder()
                    .id(UUID.fromString("f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454"))
                    .name("Category Name")
                    .build())
            .build();

    private ProductSearchRequest productSearchRequest = new ProductSearchRequest();

    @BeforeEach
    public void before() {
        productRepository = mock(ProductRepository.class);
        productQueryRepository = mock(ProductQueryRepository.class);

        when(productRepository.addProduct(createProduct)).thenReturn(product);

        PageResult<Product> result = new PageResult<>();
        result.setResult(new ArrayList<Product>(){{add(product);}});
        result.setCount(1l);
        when(productQueryRepository.searchProduct(productSearchRequest)).thenReturn(result);

        productService = new ProductServiceImpl(productRepository, productQueryRepository);
    }

    @Test
    public void givenNewProduct_whenAddProduct_thenCorrect() {
        final Product result = productService.addProduct(createProduct);

        verify(productRepository, times(1)).addProduct(createProduct);

        assertThat(result, is(notNullValue()));
        assertThat(result.getSku(), is("SKU"));
        assertThat(result.getName(), is("Product Name"));
        assertThat(result.getPrice(), is(BigDecimal.valueOf(100000)));
        assertThat(result.getStock(), is(100l));
        assertThat(result.getCategory().getId(), is(UUID.fromString("f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454")));
        assertThat(result.getCategory().getName(), is("Category Name"));
    }

    @Test
    public void givenProductSearchRequest_whenSearchProduct_thenCorrect() {
        final PageResult<Product> result = productService.searchProduct(productSearchRequest);

        verify(productQueryRepository, times(1)).searchProduct(productSearchRequest);

        assertThat(result, is(notNullValue()));
        assertThat(result.getCount(), is(1l));
        result.getResult().forEach(prd -> {
            assertThat(prd.getName(), is("Product Name"));
            assertThat(prd.getPrice(), is(BigDecimal.valueOf(100000)));
            assertThat(prd.getStock(), is(100l));
            assertThat(prd.getCategory().getId(), is(UUID.fromString("f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454")));
            assertThat(prd.getCategory().getName(), is("Category Name"));
        });
    }
}
