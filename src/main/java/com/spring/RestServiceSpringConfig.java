package com.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Alexander Kuidin on 018 18.09.17.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ={ "com.cookie"})
@Import(DbManagerServiceSpringConfig.class)
public class RestServiceSpringConfig {


}
