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
        basePackages = "rr.sebrae.apropriacao.app.database.automacaoproducao.table",
        entityManagerFactoryRef = "automacaoProducaoEntityManagerFactory",
        transactionManagerRef = "automacaoProducaoTransactionManager"
)
public class AutomacaoProducaoDataSourceConfig {

        @Bean(name = "automacaoProducaoDataSource")
        public DataSource automacaoProducaoDataSource() {
            return (DataSource) new JndiDataSourceLookup().getDataSource("java:/datasources/AutomacaoProducao");
        }

        @Bean(name = "automacaoProducaoEntityManagerFactory")
        public LocalContainerEntityManagerFactoryBean automacaoProducaoEntityManagerFactory(
                EntityManagerFactoryBuilder builder,
                @Qualifier("automacaoProducaoDataSource") DataSource dataSource) {
            return builder
                    .dataSource(dataSource)
                    .packages("rr.sebrae.apropriacao.app.database.automacaoproducao.table")
                    .persistenceUnit("automacaoProducaoPU")
                    .build();
        }

        @Bean(name = "automacaoProducaoTransactionManager")
        public PlatformTransactionManager automacaoProducaoTransactionManager(
                @Qualifier("automacaoProducaoEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
            return new JpaTransactionManager(entityManagerFactory);
        }
}
