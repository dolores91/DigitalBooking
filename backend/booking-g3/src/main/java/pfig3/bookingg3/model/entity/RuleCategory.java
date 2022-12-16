package pfig3.bookingg3.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rule_category")
public class RuleCategory {

    @Id
    @Column(name = "idrule_category")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
}
