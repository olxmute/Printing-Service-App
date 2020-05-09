package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.nmu.printingservice.service.PosterService;
import ua.nmu.printingservice.service.StickerService;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping({"/", "home"})
@RequiredArgsConstructor
public class MainPageController {

    private final PosterService posterService;
    private final StickerService stickerService;

    @GetMapping
    public String getMainPage(Model model) {
        model.addAttribute("posters", posterService.findAll().stream().limit(5).collect(toList()));
        model.addAttribute("stickers", stickerService.findAll().stream().limit(5).collect(toList()));
        return "main-page";
    }

}
