package ua.nmu.printingservice.persistence.domain.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ua.nmu.printingservice.persistence.domain.BaseEntity;
import ua.nmu.printingservice.persistence.domain.User;
import ua.nmu.printingservice.persistence.domain.enums.ProductType;
import ua.nmu.printingservice.persistence.domain.material.AbstractMaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class AbstractProduct extends BaseEntity {

    @Lob
    private String image;
    private String description;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal basePrice;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private ProductType dtype;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public abstract AbstractMaterial getMaterial();

    public BigDecimal getTotalPrice() {
        return basePrice.add(basePrice.multiply(getMaterial().getPriceMultiplier()));
    }

}
