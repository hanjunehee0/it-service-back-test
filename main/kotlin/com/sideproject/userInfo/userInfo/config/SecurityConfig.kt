package com.sideproject.userInfo.userInfo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig(
        private val jwtConfig: JwtConfig
) {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
                .csrf { }
                .sessionManagement { }
                .headers { }
                .exceptionHandling { }
                .authorizeHttpRequests { requests ->
                    requests.anyRequest().permitAll()
                }
                .formLogin { it.disable() }
                .httpBasic { it.disable() }

        return http.build()
    }

}