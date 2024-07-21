package davenkin.springboot.web.template;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class SpringbootWebTemplateApplicationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldSayHelloWorld() {
        var result = this.webTestClient.get()
                .uri("/hello-world")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(Map.class)
                .returnResult()
                .getResponseBody();
        assertEquals("Hello World!", result.get("value"));
    }

}
