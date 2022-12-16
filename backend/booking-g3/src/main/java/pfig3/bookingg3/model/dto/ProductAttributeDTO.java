package pfig3.bookingg3.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributeDTO {
    private Long id;
//    private ProductDTO product;
    private AttributeDTO attribute;
}
