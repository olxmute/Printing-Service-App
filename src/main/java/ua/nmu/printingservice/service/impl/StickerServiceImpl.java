package ua.nmu.printingservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ua.nmu.printingservice.dto.StickerDto;
import ua.nmu.printingservice.persistence.repository.StickerRepository;
import ua.nmu.printingservice.service.StickerService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class StickerServiceImpl implements StickerService {

    private final StickerRepository stickerRepository;
    private final ConversionService conversionService;

    @Override
    public List<StickerDto> findAll() {
        return stickerRepository.findAll()
                .stream()
                .map(sticker -> conversionService.convert(sticker, StickerDto.class))
                .collect(toList());
    }

}