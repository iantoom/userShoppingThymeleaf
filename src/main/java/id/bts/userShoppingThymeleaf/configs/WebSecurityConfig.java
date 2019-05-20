package id.bts.userShoppingThymeleaf.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import id.bts.userShoppingThymeleaf.security.CustomAuthenticationProvider;
import id.bts.userShoppingThymeleaf.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	DaoAuthenticationProvider tes;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers("/login", "/logingo", "/logout")
				.permitAll()
			.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/logingo")
			.defaultSuccessUrl("/", true)
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
			.logoutSuccessUrl("/login")
			.permitAll()
			.and()
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			;
			
//		http
//			.authorizeRequests()
//			.and()
//			.formLogin()
//			.loginPage("/login")
//			.loginProcessingUrl("/logingo")
//			.defaultSuccessUrl("/", true) 	
////			.failureUrl("/login")
//			.usernameParameter("username")
//			.passwordParameter("password")
//			.and()
//			.logout()
//			.logoutUrl("/logout")
//			.logoutSuccessUrl("/login");
	}
}
