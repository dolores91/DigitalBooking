package pfig3.bookingg3.model.dto.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String idNumber;
    private String email;
    private String password;
    private String name;
    private String surname;
    private RoleDTO role;
}
