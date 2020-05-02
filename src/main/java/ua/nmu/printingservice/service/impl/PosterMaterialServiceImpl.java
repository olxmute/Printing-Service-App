package ua.nmu.printingservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.nmu.printingservice.persistence.domain.material.PosterMaterial;
import ua.nmu.printingservice.persistence.repository.PosterMaterialRepository;
import ua.nmu.printingservice.service.PosterMaterialService;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Service
@RequiredArgsConstructor
public class PosterMaterialServiceImpl implements PosterMaterialService {

    private final PosterMaterialRepository posterMaterialRepository;

    @Override
    public Map<String, String> getMaterialsMap() {
        return posterMaterialRepository.findAll()
                .stream()
                .collect(toMap(PosterMaterial::getId, PosterMaterial::getTypeName));
    }

}
