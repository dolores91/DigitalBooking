package pfig3.bookingg3.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pfig3.bookingg3.model.entity.jwt.User;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "image")

@NamedQueries({
        @NamedQuery(name = "Image.findByProductId", query = "SELECT i FROM Image i WHERE i.product_idproduct = :productId"),
})

public class Image {
    @Id
    @Column(name = "idimage")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    private String url;

    @Column(name = "product_idproduct")
    private Long product_idproduct;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_idproduct")
//    private Product product;
}
