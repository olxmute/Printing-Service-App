package ua.nmu.printingservice.service;

import ua.nmu.printingservice.dto.IndoorPosterDto;

import java.util.List;

public interface IndoorPosterService {
    List<IndoorPosterDto> findAll();
}
