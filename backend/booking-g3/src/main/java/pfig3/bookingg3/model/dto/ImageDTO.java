package pfig3.bookingg3.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {
    private Long id;
    private String title;
    private String description;
    private String url;
    private Long product_idproduct;
//    private ProductDTO product;
}
