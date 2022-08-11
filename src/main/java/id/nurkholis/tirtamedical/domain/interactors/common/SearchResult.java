package id.nurkholis.tirtamedical.domain.interactors.common;

import id.nurkholis.tirtamedical.domain.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchResult  {
    List<Product> productList;
}
