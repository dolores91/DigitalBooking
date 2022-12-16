package pfig3.bookingg3.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "product")

@NamedQueries({
        @NamedQuery(name = "Product.findByCity", query = "SELECT p FROM Product p WHERE p.city.id = :cityId"),
        @NamedQuery(name = "Product.findByCategory", query = "SELECT p FROM Product p WHERE p.category.id = :categoryId"),
        @NamedQuery(name = "Product.findProductByDates", query = "SELECT p FROM Product p WHERE p.id in (SELECT DISTINCT b.product.id FROM Booking b WHERE ((b.checkInDate <= :checkInDate and b.checkOutDate >= :checkInDate) \n" +
                " or (b.checkInDate <= :checkOutDate and b.checkInDate >= :checkInDate))) GROUP BY p.id"),
        @NamedQuery(name = "Product.findProductByCityAndDates", query = "SELECT p FROM Product p WHERE p.city.id = :cityId AND p.id not in (SELECT DISTINCT b.product.id FROM Booking b WHERE ((b.checkInDate <= :checkInDate and b.checkOutDate >= :checkInDate) \n" +
                " or (b.checkInDate <= :checkOutDate and b.checkInDate >= :checkInDate))) GROUP BY p.id"),
})


public class Product {

    @Id
    @Column(name = "idproduct")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="name")
    private String name;
    @Column(name = "main_description")
    private String mainDescription;
    @Column(name = "descriptionA")
    private String descriptionA;
    @Column(name = "descriptionB")
    private String descriptionB;
    @Column(name = "descriptionC")
    private String descriptionC;
    @Column(name = "descriptionD")
    private String descriptionD;
    @Column(name = "address")
    private String address;
    @Column(name = "location_detail")
    private String location_detail;
    @Column(name = "latitude")
    private Float latitude;
    @Column(name = "longitude")
    private Float longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "city_idcity")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "category_idcategory")
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "product_idproduct")
    private Set<Image> imageSet = new HashSet<>();

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    @JoinColumn(name = "rule_idrule")
//    private Set<Rule> ruleSet = new HashSet<>();


}

