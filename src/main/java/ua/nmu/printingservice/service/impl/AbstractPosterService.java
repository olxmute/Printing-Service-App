package ua.nmu.printingservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.nmu.printingservice.dto.PosterDto;
import ua.nmu.printingservice.persistence.domain.product.AbstractPoster;
import ua.nmu.printingservice.service.PosterService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
public abstract class AbstractPosterService<T extends AbstractPoster> implements PosterService {

    protected final ConversionService conversionService;
    protected final JpaRepository<T, String> repository;

    @Override
    public List<PosterDto> findAll() {
        return repository.findAll()
                .stream()
                .map(indoorPoster -> conversionService.convert(indoorPoster, PosterDto.class))
                .collect(toList());
    }

}