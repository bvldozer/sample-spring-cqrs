package id.nurkholis.tirtamedical.command.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RabbitConfiguration {

    @Value("${event.exchange}")
    private String eventExchange;

    @Value("${event.queue}")
    private String eventQueue;

    @Bean
    public CachingConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    @Qualifier("rabbitTemplate")
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setExchange(eventExchange);
        rabbitTemplate.setMessageConverter(getMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter getMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setMessageConverter(getMessageConverter());
        return factory;
    }

    @Bean
    public TopicExchange eventExchange() {
        return new TopicExchange(eventExchange, true, false);
    }

    @Bean
    public Queue eventQueue() {
        return new Queue(eventQueue, false, false, false);
    }

    @Bean
    public Binding eventBinding() {
        return BindingBuilder.bind(eventQueue()).to(eventExchange()).with("tirta.event.queue.#");
    }

}
