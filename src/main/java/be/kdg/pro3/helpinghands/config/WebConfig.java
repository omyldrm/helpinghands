package be.kdg.pro3.helpinghands.config;

import be.kdg.pro3.helpinghands.presentation.converters.StringToEventCategoryConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// WebMvcConfigurer lets us customize Spring MVC (converters, interceptors, etc.) without replacing Spring Boot's defaults
public class WebConfig implements WebMvcConfigurer {

    private final StringToEventCategoryConverter categoryConverter;

    // injection
    public WebConfig(StringToEventCategoryConverter categoryConverter) {
        this.categoryConverter = categoryConverter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // registers the converter with sb MVC
        registry.addConverter(categoryConverter);
    }
}