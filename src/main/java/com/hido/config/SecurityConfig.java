package com.hido.config;

import com.hido.filters.StatelessAuthenticationFilter;
import com.hido.filters.StatelessLoginFilter;
import com.hido.service.TokenAuthenticationService;
import com.hido.service.UserService;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  @Autowired
  private UserService userService;

  @Autowired
  private TokenAuthenticationService tokenAuthenticationService;

  public SecurityConfig() {
    super(true);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.exceptionHandling()
        .and().anonymous()
        .and().servletApi()
        .and().headers().cacheControl();

    http.authorizeRequests()
        .antMatchers("/resources/**", "/users/registration", "/login").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/login")
        .successForwardUrl("/check")
        .failureForwardUrl("/error")
        .permitAll()
        .and()
        .logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());

    http.addFilterBefore(
        new StatelessLoginFilter("/login", tokenAuthenticationService, userService, authenticationManager()),
        UsernamePasswordAuthenticationFilter.class);

    http.addFilterBefore(
        new StatelessAuthenticationFilter(tokenAuthenticationService),
        UsernamePasswordAuthenticationFilter.class);
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
  }

  @Override
  protected UserDetailsService userDetailsService() {
    return userService;
  }

  @Bean
  public CsrfTokenRepository cookieCsrfTokenRepository() {
    CookieCsrfTokenRepository cookieCsrfTokenRepository = new CookieCsrfTokenRepository();
    cookieCsrfTokenRepository.setCookieHttpOnly(false);
    return cookieCsrfTokenRepository;
  }

  @Autowired
  public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery("select name,password from users where name=?")
        .authoritiesByUsernameQuery("select r.name from roles r inner join users u on u.role=r.id where u.name=?");
  }
}
