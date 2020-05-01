package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.nmu.printingservice.service.IndoorPosterService;
import ua.nmu.printingservice.service.OutdoorPosterService;

@Controller
@RequiredArgsConstructor
public class PosterController {

    private final IndoorPosterService indoorPosterService;
    private final OutdoorPosterService outdoorPosterService;

    @GetMapping("indoor-posters")
    public String getIndoorPosters(Model model) {
        model.addAttribute("indoorPosters", indoorPosterService.findAll());

        return "/products/indoor-poster-list";
    }

    @GetMapping("outdoor-posters")
    public String getOutdoorPosters(Model model) {
        model.addAttribute("outdoorPosters", outdoorPosterService.findAll());

        return "/products/outdoor-poster-list";
    }

}
