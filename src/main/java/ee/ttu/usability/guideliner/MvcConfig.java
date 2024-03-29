package ee.ttu.usability.guideliner;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ee.ttu.usability.guideliner.util.Logger;

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Logger.Info("Adding registry");
        registry
                .addResourceHandler("/guidelines/**")
                .addResourceLocations("classpath:/guideliner/");

        registry
                .addResourceHandler("/app/**")
                .addResourceLocations("classpath:/app/");

        registry
                .addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/assets/");

        registry
                .addResourceHandler("/css/**")
                .addResourceLocations("classpath:/css/");

        registry
                .addResourceHandler("/node_modules/**")
                .addResourceLocations("classpath:/node_modules/");
    }
}

