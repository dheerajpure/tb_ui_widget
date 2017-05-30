package com.cb.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.cb")
@ActiveProfiles("jpadao")
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = { })
public class JpaIntegrationConfig  {
}
