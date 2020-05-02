package ua.nmu.printingservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ua.nmu.printingservice.dto.ProductReadDto;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.exeptions.PosterNotFoundException;
import ua.nmu.printingservice.persistence.domain.material.PosterMaterial;
import ua.nmu.printingservice.persistence.domain.product.Poster;
import ua.nmu.printingservice.persistence.repository.PosterRepository;
import ua.nmu.printingservice.service.PosterService;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class PosterServiceImpl implements PosterService {

    protected final ConversionService conversionService;
    protected final PosterRepository posterRepository;

    @Override
    public List<ProductReadDto> findAll() {
        return posterRepository.findAll()
                .stream()
                .map(poster -> conversionService.convert(poster, ProductReadDto.class))
                .collect(toList());
    }

    @Transactional(rollbackOn = Throwable.class)
    @SneakyThrows
    @Override
    public void save(ProductWriteDto productWriteDto) {
        Poster poster = posterRepository.findById(productWriteDto.getId()).orElse(new Poster());

        poster.setBasePrice(productWriteDto.getBasePrice());
        poster.setDescription(productWriteDto.getDescription());
        poster.setHeight(productWriteDto.getHeight());
        poster.setWidth(productWriteDto.getWidth());
        poster.setOrientation(productWriteDto.getOrientation());
        poster.setMaterial(new PosterMaterial(productWriteDto.getMaterialId()));
        poster.setImage(productWriteDto.getImage());

        posterRepository.save(poster);
    }

    @Override
    public ProductWriteDto finByIdForUpdate(String id) {
        return conversionService.convert(getById(id), ProductWriteDto.class);
    }

    @Override
    public void deleteById(String id) {
        posterRepository.delete(getById(id));
    }

    private Poster getById(String id) {
        return posterRepository.findById(id).orElseThrow(PosterNotFoundException::new);
    }

}
