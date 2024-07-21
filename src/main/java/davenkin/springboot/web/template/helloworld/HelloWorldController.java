package davenkin.springboot.web.template.helloworld;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Map;

@RestController
public class HelloWorldController {

    @GetMapping(value = "/hello-world")
    public Map<String, String> helloWorld() throws NoResourceFoundException {
        throw new NoResourceFoundException(HttpMethod.GET,"/hello-world");
//        return Map.of("value", "Hello World!");
    }
}
