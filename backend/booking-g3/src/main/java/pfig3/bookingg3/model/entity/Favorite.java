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

@Table(name = "favorite")
@NamedQueries({@NamedQuery(name = "Favorite.countByProductAndCustomer", query = "SELECT COUNT(f) FROM Favorite f WHERE f.product.id = :productId AND f.user.id = :userId"),})

public class Favorite {

    @Id
    @Column(name = "idfavorite")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_idproduct")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_iduser")
    private User user;

}
