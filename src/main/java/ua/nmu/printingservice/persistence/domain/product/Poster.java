package ua.nmu.printingservice.persistence.domain.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ua.nmu.printingservice.persistence.domain.enums.Orientation;
import ua.nmu.printingservice.persistence.domain.material.PosterMaterial;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import static ua.nmu.printingservice.persistence.domain.enums.ProductType.Constants.POSTER_VALUE;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@DiscriminatorValue(POSTER_VALUE)
public class Poster extends AbstractProduct {

    @ManyToOne(fetch = FetchType.LAZY)
    private PosterMaterial material;

    @Enumerated(EnumType.STRING)
    private Orientation orientation;

}