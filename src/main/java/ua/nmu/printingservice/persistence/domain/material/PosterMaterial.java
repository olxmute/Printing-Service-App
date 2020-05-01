package ua.nmu.printingservice.persistence.domain.material;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PosterMaterial extends AbstractMaterial {
}
