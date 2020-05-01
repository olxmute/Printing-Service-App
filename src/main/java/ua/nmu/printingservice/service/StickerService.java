package ua.nmu.printingservice.service;

import ua.nmu.printingservice.dto.StickerDto;

import java.util.List;

public interface StickerService {
    List<StickerDto> findAll();
}