package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.persistence.domain.enums.Orientation;
import ua.nmu.printingservice.persistence.domain.enums.ProductType;
import ua.nmu.printingservice.service.MaterialService;
import ua.nmu.printingservice.service.PosterService;

@Controller
@RequestMapping("posters")
@RequiredArgsConstructor
public class PosterController {

    private final PosterService posterService;
    private final MaterialService materialService;

    @GetMapping("list")
    public String getPosters(Model model) {
        model.addAttribute("posters", posterService.findAll());
        return "/products/poster-list";
    }

    @GetMapping("add")
    public String getCreatePosterPage(Model model) {
        model.addAttribute("materials", materialService.getPosterMaterialsMap());
        model.addAttribute("orientations", Orientation.getOrientationMap());
        model.addAttribute("productWriteDto", new ProductWriteDto());
        model.addAttribute("productType", ProductType.POSTER.getValue());
        return "/products/write-poster";
    }

    @PostMapping("write")
    public String createPoster(@ModelAttribute ProductWriteDto productWriteDto) {
        posterService.save(productWriteDto);
        return "redirect:/posters/list";
    }

    @GetMapping("update")
    public String getUpdatePage(@RequestParam String id, Model model) {
        model.addAttribute("materials", materialService.getPosterMaterialsMap());
        model.addAttribute("orientations", Orientation.getOrientationMap());
        model.addAttribute("productWriteDto", posterService.finByIdForUpdate(id));
        model.addAttribute("productType", ProductType.STICKER.getValue());
        return "/products/write-poster";
    }

    @GetMapping("delete")
    public String deleteById(@RequestParam String id) {
        posterService.deleteById(id);
        return "redirect:/posters/list";
    }
}
