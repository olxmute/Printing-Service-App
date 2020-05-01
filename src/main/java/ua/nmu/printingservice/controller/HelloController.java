package ua.nmu.printingservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HelloController {

    @GetMapping
    public String helloMethod() {
        log.info("We are here");
        return "/hello/hello";
    }

    @GetMapping("/secured/hello")
    public String securedHelloMethod() {
        log.info("We are here");
        return "/hello/secured-hello";
    }

}
