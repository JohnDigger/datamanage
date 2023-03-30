package com.datamanage.datamanage.config;

import com.datamanage.datamanage.utils.JwtAuthenticationEntryPoint;
import com.datamanage.datamanage.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author 贾佳
 * @date 2023/3/24 11:56
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/back/login/authenticate").permitAll()
                .antMatchers("/back/fpenterprise/getTwenty").permitAll()
                .antMatchers("/back/fptrend/trend").permitAll()
                .antMatchers("/back/fpreason/reason").permitAll()
                .antMatchers("/back/serorderlist/getRankOrder").permitAll()
                .antMatchers("/back/sertype/getType").permitAll()
                .antMatchers("/back/sersellhalfyear/halfyear").permitAll()
                .antMatchers("/back/sersellhalfyear/count").permitAll()
                .antMatchers("/back/sershop/getTop").permitAll()
                .antMatchers("/back/sershop/getCount").permitAll()
                .antMatchers("/back/indata/getPanel").permitAll()
                .antMatchers("/back/inshop/getAll").permitAll()
                .antMatchers("/back/infarmproduct/product").permitAll()
                .antMatchers("/back/inobject/getPer").permitAll()
                .antMatchers("/back/inservice/getService").permitAll()
                .antMatchers("/back/inallyeartrend/trendMoney").permitAll()
                .antMatchers("/back/inallyeartrend/trendCount").permitAll()
                .antMatchers("/back/inallyear/getData").permitAll()
                .antMatchers("/back/insitedata/sitedata").permitAll()
                .antMatchers("/back/inchannel/channel").permitAll()
                .antMatchers("/back/indetailpanel/panel").permitAll()
                .antMatchers("/back/indetailtop/getTen").permitAll()
                .antMatchers("/back/indetailtable/getTable").permitAll()
                .antMatchers("/back/infarmscale/getPanel").permitAll()
                .antMatchers("/back/intopthirty/getThirty").permitAll()
                .antMatchers("/back/fppanel/getList").permitAll()
                .antMatchers("/back/serpanel/getList").permitAll()
                .antMatchers("/back/frontmonth/list").permitAll()
                .antMatchers("/error").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
