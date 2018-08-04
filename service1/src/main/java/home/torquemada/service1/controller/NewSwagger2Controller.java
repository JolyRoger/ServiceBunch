package home.torquemada.service1.controller;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.spring.web.DocumentationCache;
import springfox.documentation.spring.web.PropertySourcedMapping;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.spring.web.json.JsonSerializer;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2Mapper;
import springfox.documentation.swagger2.web.Swagger2Controller;
import javax.servlet.http.HttpServletRequest;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

//@Controller
@ApiIgnore
public class NewSwagger2Controller extends Swagger2Controller {

    public NewSwagger2Controller(Environment environment, DocumentationCache documentationCache,
                                 ServiceModelToSwagger2Mapper mapper, JsonSerializer jsonSerializer) {
        super(environment, documentationCache, mapper, jsonSerializer);
    }

    @RequestMapping(
            value = DEFAULT_URL,
            method = RequestMethod.GET,
            produces = { APPLICATION_JSON_VALUE, "application/hal+json" })
    @PropertySourcedMapping(
            value = "${springfox.documentation.swagger.v2.path}",
            propertyKey = "springfox.documentation.swagger.v2.path")
    @ResponseBody
    public ResponseEntity<Json> getDocumentation(
            @RequestParam(value = "group", required = false) String swaggerGroup,
            HttpServletRequest servletRequest) {
        return super.getDocumentation(swaggerGroup, servletRequest);
    }
}
