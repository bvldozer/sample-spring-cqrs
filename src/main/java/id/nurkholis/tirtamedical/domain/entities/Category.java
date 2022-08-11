package id.nurkholis.tirtamedical.domain.entities;

import lombok.*;

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
