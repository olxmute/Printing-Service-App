package ua.nmu.printingservice.service;

import ua.nmu.printingservice.dto.ProductReadDto;
import ua.nmu.printingservice.dto.ProductWriteDto;

import java.util.List;

public interface PosterService {

    List<ProductReadDto> findAll();

    void save(ProductWriteDto productReadDto);

    ProductWriteDto finByIdForUpdate(String id);

}
