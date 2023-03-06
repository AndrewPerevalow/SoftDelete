package example.com.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "shopping_cart", schema = "public", catalog = "soft_delete")
@Getter
@Setter
@NoArgsConstructor
@SQLDelete(sql = "update shopping_cart set active=false where id=?")
@SQLDeleteAll(sql = "update shopping_cart set active=false where id=?")
//@Where(clause = "active=true")
public class ShoppingCartEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private Double totalSum;
    private Boolean active;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductEntity> products;
}
