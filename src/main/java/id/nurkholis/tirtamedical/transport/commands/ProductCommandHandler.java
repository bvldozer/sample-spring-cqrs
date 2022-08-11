package id.nurkholis.tirtamedical.transport.commands;

import id.nurkholis.tirtamedical.domain.entities.CreateProduct;
import id.nurkholis.tirtamedical.domain.entities.Product;
import id.nurkholis.tirtamedical.domain.interactors.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

@Slf4j
@Component
public class ProductCommandHandler {

    @Autowired
    ProductService productService;
    @Autowired
    TransactionTemplate transaction;
    @Autowired
    @Qualifier("rabbitTemplate")
    RabbitTemplate rabbitTemplate;

    public Product createProductCommandHandler(CreateProductCommand createProductCommand) {
        Product product = transaction.execute(status ->
                productService.addProduct(CreateProduct.builder()
                        .sku(createProductCommand.getSku())
                        .name(createProductCommand.getName())
                        .price(createProductCommand.getPrice())
                        .stock(createProductCommand.getStock())
                        .categoryId(createProductCommand.getCategoryId())
                        .build())
        );

        rabbitTemplate.convertAndSend("tirta.event.queue.product", product);

        return product;
    }
}
