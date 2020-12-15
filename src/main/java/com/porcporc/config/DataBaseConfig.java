package com.porcporc.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.porcporc.entities")
@EnableJpaRepositories("com.porcporc.repository")
public class DataBaseConfig {
}
