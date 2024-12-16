package com.orgs.orgs.configurations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration {

    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http.httpBasic()
            .and()
            .authorizeRequests()
            .anyRequest().authenticated()
        return http.build()
    }

    @Bean
    fun userDetailsService(): UserDetailsService{
        val user = User.withDefaultPasswordEncoder()
            .username("kaiwang")
            .password("123")
            .roles("USER")
            .build()

        return InMemoryUserDetailsManager(user)

    }

}