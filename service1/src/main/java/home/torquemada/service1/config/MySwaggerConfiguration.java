package home.torquemada.service1.config;

import home.torquemada.service1.controller.NewSwagger2Controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.HandlerMapping;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.spring.web.PropertySourcedRequestMappingHandlerMapping;
import springfox.documentation.spring.web.json.JsonSerializer;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;

//@Configuration
public class MySwaggerConfiguration {

    @Primary
    @Bean
    public HandlerMapping swagger2ControllerMapping(Environment environment,
                                                    DocumentationCache documentationCache,
                                                    ServiceModelToSwagger2Mapper mapper,
                                                    JsonSerializer jsonSerializer) {
            return new PropertySourcedRequestMappingHandlerMapping(
                    environment,
                    new NewSwagger2Controller(environment, documentationCache, mapper, jsonSerializer));
    }
}
