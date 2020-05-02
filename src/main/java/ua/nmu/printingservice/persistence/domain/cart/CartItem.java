package ua.nmu.printingservice.persistence.domain.cart;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ua.nmu.printingservice.persistence.domain.BaseEntity;
import ua.nmu.printingservice.persistence.domain.product.AbstractProduct;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cartitems")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CartItem extends BaseEntity {
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private AbstractProduct product;
    private Integer count;
}
