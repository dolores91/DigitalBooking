package pfig3.bookingg3.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pfig3.bookingg3.model.entity.RuleCategory;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleDTO {
    private Long id;
    private String name;
    private String description;
    private Float fine;
    private RuleCategoryDTO ruleCategory;
}
