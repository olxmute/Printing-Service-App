package ua.nmu.printingservice.service.impl;

import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Sort;
import ua.nmu.printingservice.dto.ProductReadDto;
import ua.nmu.printingservice.dto.ProductWriteDto;
import ua.nmu.printingservice.persistence.domain.product.AbstractProduct;
import ua.nmu.printingservice.persistence.repository.GenericProductRepository;
import ua.nmu.printingservice.service.ProductService;

import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class AbstractProductService<T extends AbstractProduct> implements ProductService {

    protected final GenericProductRepository<T> repository;
    protected final ConversionService conversionService;
    private final Class<T> tClass;

    protected AbstractProductService(GenericProductRepository<T> repository,
                                     ConversionService conversionService,
                                     Class<T> tClass) {
        this.repository = repository;
        this.conversionService = conversionService;
        this.tClass = tClass;
    }

    public abstract T getById(String id);

    @Override
    public List<ProductReadDto> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");
        return convertAllToDto(repository.findAllByActiveAndUserNull(true, sort));
    }

    @Override
    public List<ProductReadDto> findAll(String description) {
        if (description.isEmpty()) {
            return findAll();
        }
        String regex = description.replaceAll(" +|-", ".*");
        List<T> foundProducts = repository.findAllByDescriptionMatchesRegex(regex);
        return convertAllToDto(foundProducts);
    }

    @Override
    public void save(ProductWriteDto productWriteDto) {
        T product = conversionService.convert(productWriteDto, tClass);
        repository.save(product);
    }

    @Override
    public ProductWriteDto finByIdForUpdate(String id) {
        return conversionService.convert(getById(id), ProductWriteDto.class);
    }

    @Override
    public void deleteById(String id) {
        repository.delete(getById(id));
    }

    private List<ProductReadDto> convertAllToDto(List<T> allByActiveAndUserNull) {
        return allByActiveAndUserNull
                .stream()
                .map(product -> conversionService.convert(product, ProductReadDto.class))
                .collect(toList());
    }
}
