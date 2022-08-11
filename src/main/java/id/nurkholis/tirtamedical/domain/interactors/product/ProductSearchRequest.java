package id.nurkholis.tirtamedical.domain.interactors.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearchRequest {
    private Set<String> sku;
    private String name;
    private BigDecimal priceStart;
    private BigDecimal priceEnd;
    private Long stockStart;
    private Long stockEnd;
    private Set<UUID> categoryId;
    private Set<String> categoryName;
}
