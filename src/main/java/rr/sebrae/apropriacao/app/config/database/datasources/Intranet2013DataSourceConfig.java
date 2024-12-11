package rr.sebrae.apropriacao.app.config.database.datasources;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "rr.sebrae.apropriacao.app.database.intranet2013.table",
        entityManagerFactoryRef = "intranet2013EntityManagerFactory",
        transactionManagerRef = "intranet2013TransactionManager"
)
public class Intranet2013DataSourceConfig {
    @Primary
    @Bean(name = "intranet2013DataSource")
    public DataSource intranet2013DataSource() {
        return (DataSource) new JndiDataSourceLookup().getDataSource("java:/datasources/Intranet2013");
    }

    @Primary
    @Bean(name = "intranet2013EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean intranet2013EntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("intranet2013DataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("rr.sebrae.apropriacao.app.database.intranet2013.table")
                .persistenceUnit("intranet2013PU")
                .build();
    }

    @Primary
    @Bean(name = "intranet2013TransactionManager")
    public PlatformTransactionManager intranet2013TransactionManager(
            @Qualifier("intranet2013EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
