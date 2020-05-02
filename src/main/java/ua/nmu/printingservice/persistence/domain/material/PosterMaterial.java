package ua.nmu.printingservice.persistence.domain.material;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class PosterMaterial extends AbstractMaterial {

    public PosterMaterial(String id) {
        super.setId(id);
    }

}
