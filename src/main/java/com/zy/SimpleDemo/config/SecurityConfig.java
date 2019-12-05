
package com.zy.SimpleDemo.config;

import com.zy.security.annotation.EnableSecurityConfiguration;
import com.zy.security.web.config.AuthenticationManagerBuilder;
import com.zy.security.web.config.subject.HttpSecurity;
import com.zy.security.web.config.subject.WebSecurityConfigurerAdapter;
import com.zy.security.web.util.AnyRequestMapping;
import com.zy.security.web.util.HttpMethod;

/**
* @author zy
* @Date 2019-11-30 周六 下午 20:34:30
* @Description 配置测试
* @version 
*/
@EnableSecurityConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(AuthenticationManagerBuilder auth) {
//		System.out.println("==SecurityConfig-auth==");
		super.configure(auth);
		
	}
	@Override
	public void configure(HttpSecurity http) {
//		System.out.println("==SecurityConfig-http==");
		http.logout()
			.logoutUrl(new AnyRequestMapping("/logout", HttpMethod.GET))
			.and()
			.authorizeRequests().antMatchers(HttpMethod.GET, "/getUser").hasAnyRole("user:add");
//			.authorizeRequests().antMatchers(HttpMethod.GET, "/getUser").hasAnyRole("user:add,edit,delete,select");
	}
}
