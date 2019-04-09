package com.raccoon.cookie;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Alexander Kuidin on 018 18.09.17.
 */

@Configuration
//@EnableTransactionManagement
@PropertySource(value = {"classpath:application.properties"})
//@ComponentScan({ "com.cookie" })
public class DbManagerServiceSpringConfig {
/*
    @Autowired
    private Environment env;

*//*    @Bean
    public DBConnectionManager dbManager() throws SQLException, ClassNotFoundException {
        return new DBConnectionManager();
    }*//*

    @Bean
    public UserRepository userRepository() throws SQLException, ClassNotFoundException {
//        return new UserRepository(dbManager());
        return new UserRepository(dataSource());
    }

    @Bean
    public CookieUserService cookieUserService()  throws SQLException, ClassNotFoundException{
        return new CookieUserService(userRepository());
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }*/
}
