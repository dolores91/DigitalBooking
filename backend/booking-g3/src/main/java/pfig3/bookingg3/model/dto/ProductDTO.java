package pfig3.bookingg3.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private String mainDescription;
    private String descriptionA;
    private String descriptionB;
    private String descriptionC;
    private String descriptionD;
    private String address;
    private String location_detail;
    private Float latitude;
    private Float longitude;
    private CityDTO city;
    private CategoryDTO category;

//    private ImageDTO image;
//    private RuleDTO rule;

    private List<ImageDTO> image;
    private List<ProductRuleDTO> productRule;
    private List<ProductAttributeDTO> productAttribute;


}
