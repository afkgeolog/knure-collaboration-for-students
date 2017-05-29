package infrastructure.config;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.nio.charset.Charset;

/**
 * Configure beans required for Hibernate use.
 *
 * @see #createEntityManagerFactory(DataSource) There are defined packages to scan to find entities.
 * @author Vladyslav Dovhopol
 */
@Configuration
@ComponentScan(basePackages = {"schedule.dao"})
@EnableTransactionManagement
public class HibernateConfiguration implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    @Primary
    public DataSourceProperties createDataSourceProperties() {
        DataSourceProperties properties = new DataSourceProperties();
        Environment environment = applicationContext.getEnvironment();

        String sqlEncoding = environment.getProperty("hibernate.datasource.sql-script-encoding");
        properties.setSqlScriptEncoding(Charset.forName(sqlEncoding));
        properties.setUrl(environment.getProperty("hibernate.datasource.url"));
        properties.setName(environment.getProperty("hibernate.datasource.name"));
        properties.setUsername(environment.getProperty("hibernate.datasource.username"));
        properties.setPassword(environment.getProperty("hibernate.datasource.password"));
        properties.setDriverClassName(environment.getProperty("hibernate.datasource.driver-class-name"));

        return properties;
    }

    @Bean
    @Primary
    public DataSource createDataSource(DataSourceProperties dataSourceProperties) {
        DataSourceBuilder builder = dataSourceProperties.initializeDataSourceBuilder();
        DataSource dataSource = builder.build();
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean createEntityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPackagesToScan("schedule.models");
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return bean;
    }

    @Bean
    public PlatformTransactionManager createTransactionManager(EntityManagerFactory entityManagerFactory,
                                                               DataSource hibernateDataSource) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        transactionManager.setDataSource(hibernateDataSource);
        return transactionManager;
    }
}
