package ua.nmu.printingservice.service;

import ua.nmu.printingservice.dto.ProductReadDto;
import ua.nmu.printingservice.dto.ProductWriteDto;

import java.util.List;

public interface ProductService {

    List<ProductReadDto> findAll();

    List<ProductReadDto> findAll(String description);

    void save(ProductWriteDto productWriteDto);

    ProductWriteDto finByIdForUpdate(String id);

    void deleteById(String id);

}
