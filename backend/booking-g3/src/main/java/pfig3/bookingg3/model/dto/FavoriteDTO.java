package pfig3.bookingg3.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pfig3.bookingg3.model.dto.jwt.UserDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteDTO {
    private Long id;
    private ProductDTO product;
    private UserDTO user;
}
