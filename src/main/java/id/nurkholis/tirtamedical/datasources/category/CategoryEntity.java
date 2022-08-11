package id.nurkholis.tirtamedical.datasources.category;

import id.nurkholis.tirtamedical.datasources.Auditable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "m_product_category")
public class CategoryEntity extends Auditable {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;
    @Column(unique=true)
    private String name;
}
