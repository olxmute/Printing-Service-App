package ua.nmu.printingservice.persistence.domain.material;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StickerMaterial extends AbstractMaterial {

    public StickerMaterial(String id) {
        super.setId(id);
    }

}