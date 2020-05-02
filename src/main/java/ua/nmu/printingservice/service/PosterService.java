package ua.nmu.printingservice.service;

import ua.nmu.printingservice.dto.ProductReadDto;

import java.util.List;

public interface PosterService {
    List<ProductReadDto> findAll();
}