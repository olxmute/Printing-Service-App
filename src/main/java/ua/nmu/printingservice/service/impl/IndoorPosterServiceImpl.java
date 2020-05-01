package ua.nmu.printingservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ua.nmu.printingservice.dto.IndoorPosterDto;
import ua.nmu.printingservice.persistence.repository.IndoorPosterRepository;
import ua.nmu.printingservice.service.IndoorPosterService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class IndoorPosterServiceImpl implements IndoorPosterService {

    private final IndoorPosterRepository indoorPosterRepository;
    private final ConversionService conversionService;

    @Override
    public List<IndoorPosterDto> findAll() {
        return indoorPosterRepository.findAll()
                .stream()
                .map(indoorPoster -> conversionService.convert(indoorPoster, IndoorPosterDto.class))
                .collect(toList());
    }

}
