package id.nurkholis.tirtamedical.query.datasources.product;

import id.nurkholis.tirtamedical.query.domain.entities.Product;
import id.nurkholis.tirtamedical.query.domain.interactors.common.PageResult;
import id.nurkholis.tirtamedical.query.domain.interactors.product.ProductSearchRequest;
import id.nurkholis.tirtamedical.query.domain.repositories.product.ProductQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductQueryMongoRepository implements ProductQueryRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void addProduct(Product product) {
        mongoTemplate.save(product);
    }

    @Override
    public PageResult<Product> searchProduct(ProductSearchRequest searchRequest) {
        Criteria productCriteria = generateProductCriteria(searchRequest);
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(productCriteria));
        AggregationResults<Product> searchAggregateResult = mongoTemplate.aggregate(aggregation, Product.class, Product.class);
        List<Product> searchResults = searchAggregateResult.getMappedResults();

        if (!searchResults.isEmpty()) {
            return new PageResult<>(searchResults);
        } else {
            return new PageResult<>();
        }
    }

    private Criteria generateProductCriteria(ProductSearchRequest searchRequest) {
        Criteria resultCriteria = new Criteria();
        if (searchRequest.getSku() != null && !searchRequest.getSku().isEmpty()) {
            resultCriteria.and("sku").in(searchRequest.getSku());
        }
        if (searchRequest.getName() != null) {
            resultCriteria.and("name").regex(searchRequest.getName());
        }
        if (searchRequest.getPriceStart() != null && searchRequest.getPriceEnd() != null) {
            resultCriteria.and("price").gte(searchRequest.getPriceStart());
            resultCriteria.and("price").lte(searchRequest.getPriceEnd());
        }
        if (searchRequest.getStockStart() != null && searchRequest.getStockEnd() != null) {
            resultCriteria.and("stock").gte(searchRequest.getStockStart());
            resultCriteria.and("stock").lte(searchRequest.getStockEnd());
        }
        if (searchRequest.getCategoryName() != null && !searchRequest.getCategoryName().isEmpty()) {
            resultCriteria.and("category.name").in(searchRequest.getCategoryName());
        }
        if (searchRequest.getCategoryId() != null && !searchRequest.getCategoryId().isEmpty()) {
            resultCriteria.and("category._id").in(searchRequest.getCategoryId());
        }

        return resultCriteria;
    }
}
