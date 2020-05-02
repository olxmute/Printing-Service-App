package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.nmu.printingservice.service.OutdoorPosterService;

@Controller
@RequestMapping("outdoor-posters")
@RequiredArgsConstructor
public class OutdoorPosterController {

    private final OutdoorPosterService outdoorPosterService;

    @GetMapping("list")
    public String getOutdoorPosters(Model model) {
        model.addAttribute("outdoorPosters", outdoorPosterService.findAll());
        return "/products/outdoor-poster-list";
    }

}