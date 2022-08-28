package br.com.alurafood.payments.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfiguration {

    @Bean
    public ModelMapper getModelMapper(){
        return  new ModelMapper();
    }
}
