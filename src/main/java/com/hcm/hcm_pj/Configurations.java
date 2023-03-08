package com.hcm.hcm_pj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class Configurations implements WebMvcConfigurer {

    @Bean
    public TilesConfigurer tilesConfigurer() {

        final TilesConfigurer configurer = new TilesConfigurer();

        // Tiles 설정 파일 위치
        configurer.setDefinitions(new String[] {"WEB-INF/tiles/**/tiles-*.xml"});
        configurer.setCheckRefresh(true);

        return configurer;
    }

    @Bean
    public TilesViewResolver tilesViewResolver() {
        final TilesViewResolver tilesViewResolver = new TilesViewResolver();

        tilesViewResolver.setViewClass(TilesView.class);
        tilesViewResolver.setOrder(1);

        return tilesViewResolver;
    }

}