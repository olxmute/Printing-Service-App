package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.nmu.printingservice.service.IndoorPosterService;

@Controller
@RequiredArgsConstructor
public class PosterController {

    private final IndoorPosterService indoorPosterService;

    @GetMapping("indoor-posters")
    public String getIndoorPosters(Model model) {
        model.addAttribute("indoorPosters", indoorPosterService.findAll());

        return "/posters/indoor-poster-list";
    }

}
