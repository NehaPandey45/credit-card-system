package com.sap.creditcard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  /**
   * create 2 users, admin and user user admin - will have access to all endpoints user - will have
   * access to only getAll()
   *
   * @param auth
   * @throws Exception
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.inMemoryAuthentication()
        .withUser("user")
        .password("{noop}password")
        .roles("USER")
        .and()
        .withUser("admin")
        .password("{noop}password")
        .roles("USER", "ADMIN");
  }

  // Secure the endpoins with HTTP Basic authentication
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        // HTTP Basic authentication
        .httpBasic()
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/creditcard/getAll")
        .hasRole("USER")
        .antMatchers(HttpMethod.POST, "/creditcard/add")
        .hasRole("ADMIN")
        .and()
        .csrf()
        .disable()
        .formLogin()
        .disable();
  }

  /*@Bean
  public UserDetailsService userDetailsService() {
      //ok for demo
      User.UserBuilder users = User.withDefaultPasswordEncoder();
      InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
      manager.createUser(users.username("user").password("password").roles("USER").build());
      manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build());
      return manager;
  }*/

}
