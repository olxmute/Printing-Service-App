package ua.nmu.printingservice.service;

import ua.nmu.printingservice.dto.ProductWriteDto;

public interface IndoorPosterService extends PosterService {

    void save(ProductWriteDto productReadDto);

    ProductWriteDto finByIdForUpdate(String id);

}
