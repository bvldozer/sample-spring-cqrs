package id.nurkholis.tirtamedical.query.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Category {
    private UUID id;
    private String name;
    private Long createdAt;

    public Category() {
    }
}
