package edu.mum.carrentalsystem.config;

import edu.mum.carrentalsystem.CarrentalsystemApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CarrentalsystemApplication.class);
    }

}
