package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring4.view.ThymeleafView;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

/**
 * @author Vladyslav Dovhopol
 */
@Configuration
@EnableWebMvc
public class WebApplicationConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("ui");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

        viewResolver.setViewClass(ThymeleafView.class);
        viewResolver.setOrder(1);
        viewResolver.setViewNames(new String[]{"*.html"});

        registry.viewResolver(viewResolver);
    }
}
