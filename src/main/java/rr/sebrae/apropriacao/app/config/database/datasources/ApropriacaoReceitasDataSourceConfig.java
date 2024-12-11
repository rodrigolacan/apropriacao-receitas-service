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
@Profile("prod")
@EnableJpaRepositories(
        basePackages = "rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table",
        entityManagerFactoryRef = "apropriacaoreceitasEntityManagerFactory",
        transactionManagerRef = "apropriacaoreceitasTransactionManager"
)
public class ApropriacaoReceitasDataSourceConfig {

    @Bean(name = "apropriacaoreceitasDataSource")
    public DataSource apropriacaoreceitasDataSource() {
        return (DataSource) new JndiDataSourceLookup().getDataSource("java:/datasources/apropriacaoReceitas");
    }

    @Bean(name = "apropriacaoreceitasEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean apropriacaoreceitasEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("apropriacaoreceitasDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("rr.sebrae.apropriacao.app.database.apropriacaoreceitas.table")
                .persistenceUnit("apropriacaoreceitasPU")
                .build();
    }

    @Bean(name = "apropriacaoreceitasTransactionManager")
    public PlatformTransactionManager apropriacaoreceitasTransactionManager(
            @Qualifier("apropriacaoreceitasEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
