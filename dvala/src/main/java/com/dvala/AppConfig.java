/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dvala;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import redis.clients.jedis.JedisShardInfo;

/**
 *
 * @author Valera
 */

@Configuration
@EnableWebMvc
public class AppConfig {
    
    @Bean
    public LoginController login() {
        return new LoginController();
    }
    
    @Bean
    public Rest rest() {
        return new Rest();
    }
    
    
    @Bean
    public Dvala dvala() {
        return new Dvala();
    }
    
    
    @Bean(name="redisTemplate")
    public RedisTemplate<String,String> getRedisTemplate() {
        RedisTemplate<String,String> rt =  new RedisTemplate<>();
        JedisConnectionFactory jcf = new JedisConnectionFactory();
        jcf.setShardInfo(new JedisShardInfo("localhost",6379));
        jcf.setUsePool(true);
        rt.setConnectionFactory(jcf);
        return rt;
    }
}
