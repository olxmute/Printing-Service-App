package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nmu.printingservice.persistence.domain.material.PosterMaterial;
import ua.nmu.printingservice.persistence.domain.material.StickerMaterial;
import ua.nmu.printingservice.persistence.repository.PosterMaterialRepository;
import ua.nmu.printingservice.persistence.repository.StickerMaterialRepository;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("materials")
@RequiredArgsConstructor
public class MaterialsController {
    private final PosterMaterialRepository posterMaterialRepository;
    private final StickerMaterialRepository stickerMaterialRepository;

    @GetMapping("poster")
    public Map<String, BigDecimal> getMaterialsMultipliers() {
        return posterMaterialRepository.findAll()
                .stream()
                .collect(Collectors.toMap(PosterMaterial::getId, PosterMaterial::getPriceMultiplier));
    }

    @GetMapping("sticker")
    public Map<String, BigDecimal> getStickerMaterialsMultipliers() {
        return stickerMaterialRepository.findAll()
                .stream()
                .collect(Collectors.toMap(StickerMaterial::getId, StickerMaterial::getPriceMultiplier));
    }

}
