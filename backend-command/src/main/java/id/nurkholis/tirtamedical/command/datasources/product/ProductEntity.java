package id.nurkholis.tirtamedical.command.datasources.product;

import id.nurkholis.tirtamedical.command.datasources.Auditable;
import id.nurkholis.tirtamedical.command.datasources.category.CategoryEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "m_product")
public class ProductEntity extends Auditable {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;
    @Column(unique=true)
    private String sku;
    private String name;
    private BigDecimal price;
    private Long stock;
    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
