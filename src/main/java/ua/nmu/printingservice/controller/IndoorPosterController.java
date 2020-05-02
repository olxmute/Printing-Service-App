package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.persistence.domain.enums.Orientation;
import ua.nmu.printingservice.service.IndoorPosterService;
import ua.nmu.printingservice.service.PosterMaterialService;

@Controller
@RequestMapping("indoor-posters")
@RequiredArgsConstructor
public class IndoorPosterController {

    private final IndoorPosterService indoorPosterService;
    private final PosterMaterialService posterMaterialService;

    @GetMapping("list")
    public String getIndoorPosters(Model model) {
        model.addAttribute("indoorPosters", indoorPosterService.findAll());
        return "/products/indoor-poster-list";
    }

    @GetMapping("add")
    public String getCreatePosterPage(Model model) {
        model.addAttribute("materials", posterMaterialService.getMaterialsMap());
        model.addAttribute("orientations", Orientation.getOrientationMap());
        model.addAttribute("productWriteDto", new ProductWriteDto());
        return "/products/create-indoor-poster";
    }

    @PostMapping("add")
    public String createPoster(@ModelAttribute ProductWriteDto productWriteDto) {
        indoorPosterService.save(productWriteDto);
        return "redirect:/indoor-posters/list";
    }
}
