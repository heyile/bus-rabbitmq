package com.example.configserver.config;

import com.example.configserver.JGit.LocalGitRepository;
import org.springframework.cloud.config.server.environment.MultipleJGitEnvironmentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public LocalGitRepository localGitRepository(MultipleJGitEnvironmentRepository multipleJGitEnvironmentRepository) {
        return new LocalGitRepository(multipleJGitEnvironmentRepository);
    }
}
