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
@Table(name = "rule")
public class Rule {
    @Id
    @Column(name = "idrule")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "fine")
    private Float fine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "rule_category_idrule_category")
    private RuleCategory ruleCategory;

}
