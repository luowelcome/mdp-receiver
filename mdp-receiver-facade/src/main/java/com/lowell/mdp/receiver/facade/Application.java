package com.lowell.mdp.receiver.facade;

/**
 * Created by Lowell on 17-7-4.
 */

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages={"com.lowell.mdp.receiver.facade.service", "com.lowell.mdp.receiver.facade.config", "com.lowell.mdp.receiver.facade.web"})
@MapperScan(basePackages = "com.lowell.mdp.receiver.facade.mapper")
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8081);
    }


    public static void main(String[] args) throws Exception {

        SpringApplication.run(Application.class, args);
        logger.debug("Sample Debug Message");
    }
}
