package home.torquemada.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Controller
@EnableSwagger2
public class Service2Application {

    public static void main(String[] args) {
        SpringApplication.run(Service2Application.class, args);
    }

    @GetMapping("/hello-service1")
    @ResponseBody
    public String hello() {
        return "Hello Service 1 [2]";
    }

    @GetMapping("/hello-service2")
    @ResponseBody
    public String index() {
        return "Hello Service 2";
    }
}
