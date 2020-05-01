package ua.nmu.printingservice.persistence.domain.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ua.nmu.printingservice.persistence.domain.material.StickerMaterial;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Sticker extends AbstractProduct {

    @ManyToOne
    private StickerMaterial material;

}
