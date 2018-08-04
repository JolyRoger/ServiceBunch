package home.torquemada.service1.controller;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

@RestController
@Slf4j
public class SwaggerJsonController {

    private static String swaggerResource = "[\n" +
            "  {\n" +
            "    \"name\": \"gson\",\n" +
            "    \"location\": \"/v2/api-docs?group=gson\",\n" +
            "    \"swaggerVersion\": \"2.0\"\n" +
            "  }\n" +
            "]";

    private static String uiConfiguration = "{\n" +
            "  \"docExpansion\": \"none\",\n" +
            "  \"apisSorter\": \"alpha\",\n" +
            "  \"defaultModelRendering\": \"schema\",\n" +
            "  \"supportedSubmitMethods\": [\n" +
            "    \"get\",\n" +
            "    \"post\",\n" +
            "    \"put\",\n" +
            "    \"delete\",\n" +
            "    \"patch\"\n" +
            "  ],\n" +
            "  \"jsonEditor\": false,\n" +
            "  \"showRequestHeaders\": true\n" +
            "}";

    private static String securityConfiguration = "{\n" +
            "  \"apiKeyName\": \"api_key\",\n" +
            "  \"scopeSeparator\": \",\",\n" +
            "  \"apiKeyVehicle\": \"header\"\n" +
            "}";

    private Json swaggerJson;

    @Autowired
    public SwaggerJsonController(Json swaggerJson) {
        this.swaggerJson = swaggerJson;
    }

//     * Responsible for returning the Swagger JSON document.
    @GetMapping(value = "/v2/api-docs", produces = {"application/json", "application/hal+json"})
    @ResponseBody
    public ResponseEntity<Json> getDocumentation(
            @RequestParam(value = "group", required = false) String swaggerGroup,
            HttpServletRequest servletRequest) {

        return new ResponseEntity(swaggerJson.value(), HttpStatus.OK);
    }

//     * Responsible for returning {@code SwaggerResource} when requested by swagger-ui.html.
    @GetMapping(value = "/swagger-resources", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Json> getSwaggerResource(
            HttpServletRequest servletRequest) {
        return new ResponseEntity(swaggerResource, HttpStatus.OK);
    }

//     * Responsible for returning {@code UIConfiguration} when requested by swagger-ui.html.
    @GetMapping(value = "/swagger-resources/configuration/ui", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Json> getUIConfiguration(
            HttpServletRequest servletRequest) {

        return new ResponseEntity(uiConfiguration, HttpStatus.OK);
    }

//     * Responsible for returning {@code SecurityConfiguration} when requested by swagger-ui.html.
    @GetMapping(value = "/swagger-resources/configuration/security", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Json> getSecurityConfiguration(
            HttpServletRequest servletRequest) {

        return new ResponseEntity(securityConfiguration, HttpStatus.OK);
    }
}
