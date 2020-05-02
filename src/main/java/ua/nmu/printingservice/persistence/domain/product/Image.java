package ua.nmu.printingservice.persistence.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Lob
    private byte[] imageBytes;
    private String imageFormat;
}
