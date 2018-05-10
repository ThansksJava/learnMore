package com.cnpc.sss.configuration.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    /**
     * protected void configure(HttpSecurity http) throws Exception {
     *     http
     *         .authorizeRequests()  //1
     *             .antMatchers("/resources/**", "/signup", "/about").permitAll() //2
     *             .antMatchers("/admin/**").hasRole("ADMIN") //3
     *             .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")            4
     *             .anyRequest().authenticated()  //5
     *             .and()
     *         // ...
     *         .formLogin();
     * }
     * 1、http.authorizeRequests()方法有多个子节点，每个macher按照他们的声明顺序执行。
     * 2、我们指定任何用户都可以访问的多个URL模式。任何用户都可以访问URL以 "/resources/",开头的URL ,以及"/signup", "/about".
     * 3、以"/admin/" 开头的URL只能由拥有 "ROLEADMIN"角色的用户访问. 请注意我们使用HasRole方法，没有使用ROLE前缀。
     * 4、任何以/db/开头的URL需要用户同时具有"ROLEADMIN" 和 "ROLE_DBA". 和上面一样我们的hasRole方法也没有使用ROLE前缀。
     * 5、尚未匹配的任何URL要求用户进行身份验证
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and()
                .formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
                /*设置登出之后将session失效，默认是true，即可以不配置此选项*/
//                .and().logout().logoutSuccessUrl("/login").invalidateHttpSession(true)
                //TODO 研究一下如何自己实现一个handler，目前这样的实现就不跳转到页面了，应该可以定制一下
//                .and().logout().logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> System.out.println("哈哈哈,注销成功了"))
                .and().logout().permitAll()
        ;
//        http.csrf().disable();
    }
}
