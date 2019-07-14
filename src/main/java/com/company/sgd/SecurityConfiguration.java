/**
 *
 */
package com.company.sgd;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.company.sgd.repository.LoginRepository;
import javax.ws.rs.HttpMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author the_d
 *
 */
@Configuration
@EnableAutoConfiguration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    LoginRepository loginRepository;

    @Value("select usuario as username, contrasena as password, estatus as enabled from usuario where usuario=?")
    private String userQuery;

    @Value("select u.usuario as username, r.nombre as authority from usuario u join rol r on(u.rol_id = r.rol_id) where u.usuario = ? ")
    private String roleQuery;

    @Autowired
    protected void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(userQuery)
                .authoritiesByUsernameQuery(roleQuery)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/fonts/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/static/**").permitAll()
                
            //AVALUO DE ACTIVOS-------------------------------------------------------------------
                .antMatchers("/avaluoactivos").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getAA").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getAAZip").hasAnyRole("USER", "ADMIN")
                
            //COMITE COMERCIAL--------------------------------------------------------------------
                .antMatchers("/comitecomercial").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentocomitecomercial").hasAnyRole("USER", "ADMIN")
                
            //COMITE COMERCIAL REPORTE------------------------------------------------------------    
                .antMatchers("/consejoadministracion").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentocomitecomercialreglas").hasAnyRole("USER", "ADMIN")
                
            //COMITE ENGORDA----------------------------------------------------------------------    
                .antMatchers("/comiteengorda").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentocomiteengorda").hasAnyRole("USER", "ADMIN")
                
            //COMITE ENGORDA REGLAS---------------------------------------------------------------   
                .antMatchers("/comiteengordareglas").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentocomiteengordareglas").hasAnyRole("USER", "ADMIN")
                    
            //COMITE INVERSIONES------------------------------------------------------------------    
                .antMatchers("/comiteinversiones").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentocomiteinversiones").hasAnyRole("USER", "ADMIN")
                
            //COMITE INVERSIONES REGLAS-----------------------------------------------------------   
                .antMatchers("/comiteinversionesreglas").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentocomiteinversionesreglas").hasAnyRole("USER", "ADMIN")
            
            //CONTRATOS FIRMADOS------------------------------------------------------------------    
                .antMatchers("/contratosfirmados").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentocontratos").hasAnyRole("USER", "ADMIN")
                
            //DOCUMENTACION LEGAL-----------------------------------------------------------------    
                .antMatchers("/documentacionlegal").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentolegal").hasAnyRole("USER", "ADMIN")
            
            //ESTADOS FINANCIEROS-----------------------------------------------------------------    
                .antMatchers("/edosfinancieros").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getEstado").hasAnyRole("USER", "ADMIN")
               
            //ERRORES-----------------------------------------------------------------------------    
                .antMatchers("/307").hasAnyRole("USER", "ADMIN")
                .antMatchers("/403").hasAnyRole("USER", "ADMIN")
                .antMatchers("/404").hasAnyRole("USER", "ADMIN")
                .antMatchers("/500").hasAnyRole("USER", "ADMIN")
                
            //ESCRITURAS--------------------------------------------------------------------------    
                .antMatchers("/escrituras").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentoescrituras").hasAnyRole("USER", "ADMIN")
            
            //FACTURAS DE ACTIVOS-----------------------------------------------------------------    
                .antMatchers("/facturasactivos").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getFA").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getFAZip").hasAnyRole("USER", "ADMIN")
                
            //GENERAL DOWNLOAD--------------------------------------------------------------------
                .antMatchers("/gestor").hasAnyRole("USER", "ADMIN")
                .antMatchers("/documentos").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentogeneral").hasAnyRole("USER", "ADMIN")
                
            //GOBIERNO CORPORATIVO----------------------------------------------------------------
                .antMatchers("/gobiernocorporativo").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentogobierno").hasAnyRole("USER", "ADMIN")
            
            //INFORMACION INDUSTRIA---------------------------------------------------------------
                .antMatchers("/informacionindus").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentoinformacion").hasAnyRole("USER", "ADMIN")
                
            //INFORME ACTIVIDADES-----------------------------------------------------------------
                .antMatchers("/informeactividades").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentoInforme").hasAnyRole("USER", "ADMIN")
                    
            //MENU--------------------------------------------------------------------------------
                .antMatchers("/menu").hasAnyRole("USER", "ADMIN")
                
            //ORGANIGRAMA-------------------------------------------------------------------------
                .antMatchers(HttpMethod.POST,"/downorganigrama").hasAnyRole("USER", "ADMIN")
                
            //PLAN DE TRABAJO---------------------------------------------------------------------
                .antMatchers("/plantrabajo").hasAnyRole("USER", "ADMIN")           
                .antMatchers(HttpMethod.POST,"/plantrabajo/descargaplan").hasAnyRole("USER", "ADMIN")
                
            //PRESENTACIONES CORPORATIVAS---------------------------------------------------------
                .antMatchers("/presentacionesCorporativas").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentopresentaciones").hasAnyRole("USER", "ADMIN")
                
            //PROYECTO EJECUTIVO------------------------------------------------------------------    
                .antMatchers("/proyectoejecutivo").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentoejecutivo").hasAnyRole("USER", "ADMIN")
                
            //REGLAS OPERACION--------------------------------------------------------------------    
                .antMatchers("/reglasoperacion").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentoreglas").hasAnyRole("USER", "ADMIN")
                
            //REPORTE VENTAS----------------------------------------------------------------------
                .antMatchers("/reporteventas").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getReporte").hasAnyRole("USER", "ADMIN")
                
            //SAGARPA-----------------------------------------------------------------------------
                .antMatchers("/sagarpa").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getdocumentoSagarpa").hasAnyRole("USER", "ADMIN")
                
            //SEGUROS-----------------------------------------------------------------------------
                .antMatchers("/seguros").hasAnyRole("USER", "ADMIN")                
                .antMatchers(HttpMethod.POST,"/getS").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST,"/getSZip").hasAnyRole("USER", "ADMIN")
                
            //OTROS-------------------------------------------------------------------------------    
                .antMatchers("/filemanager").hasAnyRole("USER", "ADMIN")
                .antMatchers("/cargaarchivos").hasAnyRole("USER", "ADMIN")
                .antMatchers("/generaldownload").hasAnyRole("USER", "ADMIN")
                .antMatchers("/nuevocomitecomercial").hasAnyRole("USER", "ADMIN")     
                .antMatchers(HttpMethod.POST,"/getdocumentogeneral").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/index").failureUrl("/500")
                .defaultSuccessUrl("/menu", true)
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .clearAuthentication(true);

        http
                .formLogin()
                .permitAll().and().sessionManagement().maximumSessions(1).expiredUrl("/307");

        http
                .headers()
                .contentTypeOptions()
                .and()
                .xssProtection()
                .and()
                .cacheControl()
                .and()
                .httpStrictTransportSecurity()
                .and()
                .frameOptions();

        http
                .exceptionHandling()
                .accessDeniedPage("/403");
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
