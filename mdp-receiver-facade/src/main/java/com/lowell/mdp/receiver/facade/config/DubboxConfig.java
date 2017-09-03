package com.lowell.mdp.receiver.facade.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Lowell on 17-7-5.
 */
@Configuration
@ImportResource("classpath:mdp_receiver.facade.dubbo.xml")
public class DubboxConfig {
}
