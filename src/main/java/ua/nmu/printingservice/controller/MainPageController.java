package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.nmu.printingservice.service.PosterService;

@Controller
@RequestMapping({"/", "home"})
@RequiredArgsConstructor
public class MainPageController {

    private final PosterService posterService;

    @GetMapping
    public String getMainPage(Model model) {
        model.addAttribute("posters", posterService.findAll());
        return "main-page";
    }

}
