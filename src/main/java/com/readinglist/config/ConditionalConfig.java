package com.readinglist.config;

import com.readinglist.domain.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ConditionalConfig {
    @Bean
    @Conditional(MagicExistsConditional.class) //条件化的创建bea
//    @Profile(value = "test")
    public Book magicBean() {
        return new Book();
    }
}
