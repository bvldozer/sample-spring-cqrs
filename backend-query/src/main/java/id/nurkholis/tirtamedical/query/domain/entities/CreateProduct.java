package id.nurkholis.tirtamedical.query.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
public class CreateProduct {
    @NotBlank
    private String sku;
    @NotBlank
    @Size(max = 255)
    private String name;
    @PositiveOrZero
    private BigDecimal price;
    private Long stock;
    private UUID categoryId;
}
