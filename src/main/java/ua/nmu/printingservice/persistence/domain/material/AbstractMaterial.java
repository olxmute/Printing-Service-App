package ua.nmu.printingservice.persistence.domain.material;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import ua.nmu.printingservice.persistence.domain.enums.PaperQuality;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "materials")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class AbstractMaterial {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Enumerated(EnumType.STRING)
    private PaperQuality paperQuality;

    private String typeName;
    private BigDecimal priceMultiplier;

}
