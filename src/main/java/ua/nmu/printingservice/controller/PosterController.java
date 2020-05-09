package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.persistence.domain.enums.Orientation;
import ua.nmu.printingservice.persistence.domain.enums.ProductType;
import ua.nmu.printingservice.security.annotation.Access;
import ua.nmu.printingservice.service.MaterialService;
import ua.nmu.printingservice.service.PosterService;

import javax.validation.Valid;

@Controller
@RequestMapping("posters")
@RequiredArgsConstructor
public class PosterController {

    private final PosterService posterService;
    private final MaterialService materialService;

    @GetMapping("list")
    public String getPosters(Model model) {
        model.addAttribute("products", posterService.findAll());
        model.addAttribute("productType", ProductType.POSTER.getValue());
        return "/products/product-list";
    }

    @Access.Admin
    @GetMapping("add")
    public String getCreatePosterPage(Model model) {
        model.addAttribute("materials", materialService.getPosterMaterialsMap());
        model.addAttribute("productWriteDto", new ProductWriteDto());
        model.addAttribute("productType", ProductType.POSTER.getValue());
        return "/products/write-poster";
    }

    @Access.Admin
    @PostMapping("write")
    public String createPoster(@ModelAttribute @Valid ProductWriteDto productWriteDto,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productType", ProductType.POSTER.getValue());
            model.addAttribute("materials", materialService.getPosterMaterialsMap());
            return "/products/write-poster";
        }
        posterService.save(productWriteDto);
        return "redirect:/posters/list";
    }

    @Access.Admin
    @GetMapping("update")
    public String getUpdatePage(@RequestParam String id, Model model) {
        model.addAttribute("materials", materialService.getPosterMaterialsMap());
        model.addAttribute("productWriteDto", posterService.finByIdForUpdate(id));
        model.addAttribute("productType", ProductType.POSTER.getValue());
        return "/products/write-poster";
    }

    @Access.Admin
    @GetMapping("delete")
    public String deleteById(@RequestParam String id) {
        posterService.deleteById(id);
        return "redirect:/posters/list";
    }
}
