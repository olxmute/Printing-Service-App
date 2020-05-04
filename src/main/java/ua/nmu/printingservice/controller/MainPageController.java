package ua.nmu.printingservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "home"})
public class MainPageController {

    @GetMapping
    public String getMainPage() {
        return "main-page";
    }

}
