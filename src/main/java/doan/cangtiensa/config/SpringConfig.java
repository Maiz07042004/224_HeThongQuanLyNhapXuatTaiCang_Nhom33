/*
 * (C) Copyright 2019 Fresher Academy. All Rights Reserved 
 *
 *	@author HCD-Fresher009
 *	@date Oct 18, 2019
 *	@version 1.0
 */
package doan.cangtiensa.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "doan.cangtiensa.repository")
public class SpringConfig {

	@Bean
	DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://DESKTOP-6754H25:1433; databaseName=CangTienSa;user=sa;password=123123;"
				+ "encrypt=true;trustServerCertificate=true");

		/* dataSource.setUsername("sa"); dataSource.setPassword("123123"); */

		return dataSource;
	}

	 @Bean
	    public CommonsMultipartResolver multipartResolver() {
	        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	        multipartResolver.setMaxUploadSize(10485760); // 10MB
	        return multipartResolver;
	    }
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataSource);
		entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManager.setPackagesToScan("doan.cangtiensa.entity");

		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		jpaProperties.setProperty("hibernate.connection.CharSet", "UTF8");
		jpaProperties.setProperty("hibernate.connection.characterEncoding", "UTF8");
		jpaProperties.setProperty("hibernate.connection.useUnicode", "true");
		/* jpaProperties.setProperty("hibernate.show_sql", "true"); */
		entityManager.setJpaProperties(jpaProperties);
		return entityManager;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
		return jpaTransactionManager;
	}
}