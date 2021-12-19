//package com.example.mydemo;
//
//import org.apache.catalina.filters.CorsFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//public class CorsConfig {
//    private static final long MAX_AGE = 24*60*60;
//
//    private CorsConfiguration buildConfig(){
//        CorsConfiguration corsConfiguration= new CorsConfiguration();
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedMethod("*");
//        corsConfiguration.setMaxAge(MAX_AGE);
//        return corsConfiguration;
//    }
//
//    @Bean
//    public CorsFilter corsFilter(){
//        UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**",buildConfig());
//        return new CorsFilter(source);
//    }
//}
