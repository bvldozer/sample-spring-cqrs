package id.nurkholis.tirtamedical.transport.commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class CreateProductCommand {
    private final String sku;
    private final String name;
    private final BigDecimal price;
    private final Long stock;
    private final UUID categoryId;
}
