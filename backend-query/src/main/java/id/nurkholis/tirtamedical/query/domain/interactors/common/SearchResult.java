package id.nurkholis.tirtamedical.query.domain.interactors.common;

import id.nurkholis.tirtamedical.query.domain.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchResult  {
    List<Product> productList;
}
