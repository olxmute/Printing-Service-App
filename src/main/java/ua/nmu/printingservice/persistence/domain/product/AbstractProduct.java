package ua.nmu.printingservice.persistence.domain.product;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import ua.nmu.printingservice.persistence.domain.material.AbstractMaterial;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class AbstractProduct {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Lob
    private String image;
    private String description;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal basePrice;

    public abstract AbstractMaterial getMaterial();

    public BigDecimal getTotalPrice() {
        return basePrice.add(basePrice.multiply(getMaterial().getPriceMultiplier()));
    }

}
