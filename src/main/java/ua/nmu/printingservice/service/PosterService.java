package ua.nmu.printingservice.service;

import ua.nmu.printingservice.dto.PosterDto;

import java.util.List;

public interface PosterService {
    List<PosterDto> findAll();
}