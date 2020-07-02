package com.xsz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Value("${imagesPath}")
    private String mImagesPath;
    @Value("${wordPath}")
    private String wordPath;
    @Value("${applicationPath}")
    private String applicationPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/images/**", "/word/**", "/application/**").addResourceLocations(mImagesPath, wordPath, applicationPath);
    }


}

