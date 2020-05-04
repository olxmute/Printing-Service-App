package ua.nmu.printingservice.service;

import ua.nmu.printingservice.dto.ProductWriteDto;

public interface PosterService extends ProductService {

    void save(ProductWriteDto productReadDto);

    ProductWriteDto finByIdForUpdate(String id);

    void deleteById(String id);

}
