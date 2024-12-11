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
        basePackages = "rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table",
        entityManagerFactoryRef = "apropriacaoreceitashomologEntityManagerFactory",
        transactionManagerRef = "apropriacaoreceitashomologTransactionManager"
)
public class ApropriacaoReceitasHomologDataSourceConfig {
    @Bean(name = "apropriacaoreceitashomologDataSource")
    public DataSource apropriacaoreceitashomologDataSource() {
        return (DataSource) new JndiDataSourceLookup().getDataSource("java:/datasources/apropriacaoReceitasHomolog");
    }

    @Bean(name = "apropriacaoreceitashomologEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean apropriacaoreceitashomologEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("apropriacaoreceitashomologDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("rr.sebrae.apropriacao.app.database.apropriacaoreceitashomolog.table")
                .persistenceUnit("apropriacaoreceitashomologPU")
                .build();
    }

    @Bean(name = "apropriacaoreceitashomologTransactionManager")
    public PlatformTransactionManager apropriacaoreceitashomologTransactionManager(
            @Qualifier("apropriacaoreceitashomologEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
