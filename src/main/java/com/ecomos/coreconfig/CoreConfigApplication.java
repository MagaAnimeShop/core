package com.ecomos.coreconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.request.RequestContextListener;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

@SpringBootApplication
public class CoreConfigApplication implements ServletContextAware {

    public static void main(String[] args) {
        SpringApplication.run(CoreConfigApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                new FacesServlet(), "*.xhtml");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        // Iniciar el contexto de JSF
        // http://stackoverflow.com/a/25509937/1199132
        //   servletContext.addListener(new ContextLoaderListener());
        servletContext.addListener(new RequestContextListener());
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");
        servletContext.setInitParameter("primefaces.UPLOADER", "commons");
        servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Development");
    }

}
