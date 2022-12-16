package pfig3.bookingg3.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product_attribute")

@NamedQueries({
        @NamedQuery(name = "Product_Attribute.findByProductId", query = "SELECT p FROM ProductAttribute p WHERE p.product.id = :productId"),
})

public class ProductAttribute {
    @Id
    @Column(name = "idproduct_attribute")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name ="product_idproduct")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "attribute_idattribute")
    private Attribute attribute;
}
