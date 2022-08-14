package id.nurkholis.tirtamedical.command.configs;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories({
        "id.nurkholis.tirtamedical.datasources"
})
@EntityScan({
        "id.nurkholis.tirtamedical.datasources"
})
public class DataSourceConfiguration {

    @Bean
    public TransactionTemplate defaultTransactionTemplate(PlatformTransactionManager manager) {
        final DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        definition.setTimeout(TransactionDefinition.TIMEOUT_DEFAULT);

        return new TransactionTemplate(manager, definition);
    }
}
