package pfig3.bookingg3.model.entity.jwt;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pfig3.bookingg3.model.entity.City;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity

@Table(name= "user")
public class User {
    @Id
    @Column(name = "iduser")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idnumber")
    private String idNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    //role
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_idrole")
    private Role role;

}
