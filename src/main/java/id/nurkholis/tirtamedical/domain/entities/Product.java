package id.nurkholis.tirtamedical.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Product {
    private UUID id;
    private String sku;
    private String name;
    private BigDecimal price;
    private Long stock;
    private Category category;
    private Long createdAt;

    public Product() {
    }
}
