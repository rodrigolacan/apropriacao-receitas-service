package rr.sebrae.apropriacao.app.config.database.datasources;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "rr.sebrae.apropriacao.app.database.apisebrae.table",
        entityManagerFactoryRef = "apiSebraeEntityManagerFactory",
        transactionManagerRef = "apiSebraeTransactionManager"
)
public class ApiSebraeDataSourceConfig {

    @Bean(name = "apiSebraeDataSource")
    public DataSource apiSebraeDataSource() {
        return (DataSource) new JndiDataSourceLookup().getDataSource("java:/datasources/APISEBRAE");
    }


    @Bean(name = "apiSebraeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean apiSebraeEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("apiSebraeDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("rr.sebrae.apropriacao.app.database.apisebrae.table")
                .persistenceUnit("apiSebraePU")
                .build();
    }

    @Bean(name = "apiSebraeTransactionManager")
    public PlatformTransactionManager apiSebraeTransactionManager(
            @Qualifier("apiSebraeEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
