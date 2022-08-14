package id.nurkholis.tirtamedical.command.domain.interactors.common;

import id.nurkholis.tirtamedical.command.domain.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchResult  {
    List<Product> productList;
}
