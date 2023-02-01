package com.example.listacompra.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class listaCompraDataSource {

	//JDBC DETAILS MANAGER
	@Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(@Qualifier("db1") DataSource ds) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(ds);
        return jdbcUserDetailsManager;
    };
	
	@Bean("db1")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource getDBCompras() {
		return DataSourceBuilder.create().build();
	}
	@Bean("jdbcTemplateDB1")
	public JdbcTemplate getJdbcTemplateDB1(@Qualifier("db1")DataSource ds){
		return new JdbcTemplate(ds);
	}
	
	@Bean("db2")
	@ConfigurationProperties(prefix = "spring.segunda")
	public DataSource getDBProveedor() {
		return DataSourceBuilder.create().build();
	}
	@Bean("jdbcTemplateDB2")
	public JdbcTemplate getJdbcTemplateDB2(@Qualifier("db2")DataSource ds){
		return new JdbcTemplate(ds);
	}
}
