package ua.nmu.printingservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.nmu.printingservice.persistence.repository.IndoorPosterRepository;
import ua.nmu.printingservice.persistence.repository.MaterialRepository;
import ua.nmu.printingservice.persistence.repository.OutdoorPosterRepository;
import ua.nmu.printingservice.persistence.repository.PosterMaterialRepository;
import ua.nmu.printingservice.persistence.repository.ProductRepository;
import ua.nmu.printingservice.persistence.repository.StickerMaterialRepository;
import ua.nmu.printingservice.persistence.repository.StickerRepository;

@Slf4j
@SpringBootApplication
public class PrintingServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PrintingServiceApplication.class, args);

        var indoorPosterRepository = run.getBean(IndoorPosterRepository.class);
        var outdoorPosterRepository = run.getBean(OutdoorPosterRepository.class);
        var productRepository = run.getBean(ProductRepository.class);
        var stickerRepository = run.getBean(StickerRepository.class);
        var materialRepository = run.getBean(MaterialRepository.class);
        var posterMaterialRepository = run.getBean(PosterMaterialRepository.class);
        var stickerMaterialRepository = run.getBean(StickerMaterialRepository.class);

        log.info("msg");
    }

}
