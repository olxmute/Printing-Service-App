package ua.nmu.printingservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.nmu.printingservice.persistence.domain.material.PosterMaterial;
import ua.nmu.printingservice.persistence.domain.material.StickerMaterial;
import ua.nmu.printingservice.persistence.repository.PosterMaterialRepository;
import ua.nmu.printingservice.persistence.repository.StickerMaterialRepository;
import ua.nmu.printingservice.service.MaterialService;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {

    private final PosterMaterialRepository posterMaterialRepository;
    private final StickerMaterialRepository stickerMaterialRepository;

    @Override
    public Map<String, String> getPosterMaterialsMap() {
        return posterMaterialRepository.findAll()
                .stream()
                .collect(toMap(PosterMaterial::getId, PosterMaterial::getTypeName));
    }

    @Override
    public Map<String, String> getStickerMaterialsMap() {
        return stickerMaterialRepository.findAll()
                .stream()
                .collect(toMap(StickerMaterial::getId, StickerMaterial::getTypeName));
    }

}
