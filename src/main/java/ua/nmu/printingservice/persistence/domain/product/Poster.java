package ua.nmu.printingservice.persistence.domain.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ua.nmu.printingservice.persistence.domain.enums.Orientation;
import ua.nmu.printingservice.persistence.domain.material.PosterMaterial;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class Poster extends AbstractProduct {

    @ManyToOne(fetch = FetchType.LAZY)
    private PosterMaterial material;

    @Enumerated(EnumType.STRING)
    private Orientation orientation;

}