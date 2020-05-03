package ua.nmu.printingservice.persistence.domain.cart;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ua.nmu.printingservice.persistence.domain.BaseEntity;
import ua.nmu.printingservice.persistence.domain.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Cart extends BaseEntity {

    @OrderBy("createdDate DESC")
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public void addItem(CartItem item) {
        items.add(item);
    }

    public int getItemsCount() {
        return items.stream()
                .map(CartItem::getCount)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public BigDecimal getTotalPrice() {
        return items.stream()
                .map(cartItem -> cartItem.getProduct().getTotalPrice().multiply(BigDecimal.valueOf(cartItem.getCount())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
