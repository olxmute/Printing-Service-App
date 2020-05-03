package ua.nmu.printingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nmu.printingservice.persistence.domain.material.PosterMaterial;
import ua.nmu.printingservice.persistence.repository.PosterMaterialRepository;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("materials")
@RequiredArgsConstructor
public class MaterialsController {
    private final PosterMaterialRepository posterMaterialRepository;

    @GetMapping
    public Map<String, BigDecimal> getMaterialsMultipliers() {
        return posterMaterialRepository.findAll()
                .stream()
                .collect(Collectors.toMap(PosterMaterial::getId, PosterMaterial::getPriceMultiplier));
    }

}
