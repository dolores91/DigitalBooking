package pfig3.bookingg3.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name= "rule_product")

@NamedQueries({
        @NamedQuery(name = "ProductRule.findRuleByProduct", query = "SELECT p FROM ProductRule p WHERE p.product.id = :productId")
})


public class ProductRule {
    @Id
    @Column(name = "idrule_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_idproduct")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rule_idrule")
    private Rule rule;
}
