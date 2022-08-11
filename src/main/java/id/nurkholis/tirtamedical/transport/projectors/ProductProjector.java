package id.nurkholis.tirtamedical.transport.projectors;

import id.nurkholis.tirtamedical.domain.entities.Product;
import id.nurkholis.tirtamedical.domain.repositories.product.ProductQueryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductProjector {

    @Autowired
    ProductQueryRepository productQueryRepository;

    @RabbitListener(queues = "tirta.event.queue")
    @RabbitHandler
    public void handleProductCreatedEvent(Product product) {
        productQueryRepository.addProduct(product);
    }
}
