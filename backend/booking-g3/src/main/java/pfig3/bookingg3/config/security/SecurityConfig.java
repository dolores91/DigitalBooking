package pfig3.bookingg3.config.security;


import pfig3.bookingg3.config.security.jwt.JwtEntryPointConfig;
import pfig3.bookingg3.config.security.jwt.JwtTokenFilterConfig;
import pfig3.bookingg3.model.service.jwt.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;



import java.util.Arrays;


// class for JWT Token configuration for security reasons.
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtEntryPointConfig jwtEntryPointConfig;

    // Register properties to be implemented.
    @Bean
    public JwtTokenFilterConfig jwtTokenFilter() {return new JwtTokenFilterConfig();}

    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    @Bean("authenticationManager")
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }



    //Register all endpoints. Define who has access to each of them. This gives security to our app.

    @Primary
    @Bean

    protected HttpSecurity configure(HttpSecurity http) throws Exception {


        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth/**", "/api/v1/user/**", "/api/v1/search_filter/**","/api/v1/product/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/product/**", "/api/v1/category/**"
                        , "/api/v1/city/**", "/api/v1/attribute/**", "/api/v1/rule/**", "/api/v1/product_attribute/**","/api/v1/product_rule/**","/api/v1/rule_category/**", "/api/v1/rule/category/**","/api/v1/search_filter/**","/api/v1/image/**").permitAll()
                .antMatchers(HttpMethod.POST,  "/api/v1/category/**"
                        , "/api/v1/city/**", "/api/v1/attribute/**", "/api/v1/rule/**", "/api/v1/product_attribute/**"
                        , "/api/v1/role/**","/api/v1/product_rule/**","/api/v1/rule_category/**","/api/v1/rule/category/**","/api/v1/image/**").permitAll()//.hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/product/**", "/api/v1/category/**"
                        , "/api/v1/city/**", "/api/v1/attribute/**", "/api/v1/rule/**", "/api/v1/product_attribute/**"
                        , "/api/v1/role/**", "/api/v1/user/**","/api/v1/image/**").permitAll()//.hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/product/**", "/api/v1/category/**"
                        , "/api/v1/city/**", "/api/v1/attribute/**", "/api/v1/rule/**", "/api/v1/product_attribute/**"
                        , "/api/v1/role/**", "/api/v1/user/**","/api/v1/image/**").permitAll()//.hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/role/**", "/api/v1/user/**").permitAll()//.hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/booking/**", "/api/v1/favorite/**").permitAll()//.hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/booking/**", "/api/v1/favorite/**").permitAll()//.hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/booking/**", "/api/v1/favorite/**").permitAll()//.hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/booking/**", "/api/v1/favorite/**").permitAll()//.hasAnyRole("USER", "ADMIN")

                //.anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPointConfig)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http;
    }

    //Cors origins are registered so that the ecosystem allows free endpoint consumption from frontend.
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(Arrays.asList("*"));
        //config.setAllowedOrigins(Arrays.asList("http://localhost:4200", "*"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        UrlBasedCorsConfigurationSource cors = new UrlBasedCorsConfigurationSource();
        cors.registerCorsConfiguration("/**", config);
        return cors;
    }


    //Registering filters previously configured so that it becomes a springboot implemented filter. /**
    // This way, we implement the registry and open the cors.
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }


}
