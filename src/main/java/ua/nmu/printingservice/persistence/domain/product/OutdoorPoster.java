package ua.nmu.printingservice.persistence.domain.product;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class OutdoorPoster extends AbstractPoster {

}
