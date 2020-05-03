package ua.nmu.printingservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.nmu.printingservice.dto.ProductReadDto;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.exeptions.ProductNotFoundException;
import ua.nmu.printingservice.persistence.domain.product.Poster;
import ua.nmu.printingservice.persistence.repository.PosterRepository;
import ua.nmu.printingservice.service.PosterService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class PosterServiceImpl implements PosterService {

    protected final ConversionService conversionService;
    protected final PosterRepository posterRepository;

    @Override
    public List<ProductReadDto> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");
        return posterRepository.findAllByActiveAndUserNull(true, sort)
                .stream()
                .map(poster -> conversionService.convert(poster, ProductReadDto.class))
                .collect(toList());
    }

    @Override
    public void save(ProductWriteDto productWriteDto) {
        var poster = conversionService.convert(productWriteDto, Poster.class);
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
        return posterRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

}
