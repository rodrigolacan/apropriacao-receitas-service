package rr.sebrae.apropriacao.app.config.database.datasources;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@Profile("dev")
@EnableJpaRepositories(
        basePackages = "rr.sebrae.apropriacao.app.database.automacaohomolog.table",
        entityManagerFactoryRef = "automacaoHomologEntityManagerFactory",
        transactionManagerRef = "automacaoHomologTransactionManager"
)
public class AutomacaoHomologDataSourceConfig {
    @Bean(name = "automacaoHomologDataSource")
    public DataSource automacaoHomologDataSource() {
        return (DataSource) new JndiDataSourceLookup().getDataSource("java:/datasources/AutomacaoHomolog");
    }

    @Bean(name = "automacaoHomologEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean automacaoHomologEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("automacaoHomologDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("rr.sebrae.apropriacao.app.database.automacaohomolog.table")
                .persistenceUnit("automacaoHomologPU")
                .build();
    }

    @Bean(name = "automacaoHomologTransactionManager")
    public PlatformTransactionManager automacaoHomologTransactionManager(
            @Qualifier("automacaoHomologEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
