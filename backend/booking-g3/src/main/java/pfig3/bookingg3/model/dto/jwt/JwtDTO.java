package pfig3.bookingg3.model.dto.jwt;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtDTO {
    private String token;
    private String bearer;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;

}
