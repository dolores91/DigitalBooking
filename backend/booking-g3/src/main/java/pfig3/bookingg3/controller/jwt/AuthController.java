package pfig3.bookingg3.controller.jwt;

import pfig3.bookingg3.config.security.jwt.JwtProviderConfig;
import pfig3.bookingg3.model.dto.jwt.JwtDTO;
import pfig3.bookingg3.model.dto.jwt.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProviderConfig jwtProviderConfig;

    //Method to initiate Token obtention according to the user info.
    // UserDTO is received complete.

    @PostMapping("/token")
    public ResponseEntity<Map<String, Object>> token(@RequestBody UserDTO user) {
        Map<String, Object> response = new HashMap<>();

        //SPringBoot Ecosystem authentication. UsernamePasswordAuthenticationToken has the search methods and encription for the password defined.

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

        //After doing authentication and check the user exists in the db, you register the user in the request to give priority to the token management.

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generate token under the authentication result. Here you find the results that will be possible to get and set fot the usage.
        //With this the obtained info is sent to generate the token.

        String jwt = jwtProviderConfig.generateToken(authentication);

        // Get and cast the main user obtained after the authentication.

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        //Return my object. Object created by myself.

        JwtDTO jwtDTO = new JwtDTO(jwt, "Bearer", userDetails.getUsername(), userDetails.getAuthorities());
        response.put("response", jwtDTO);
        return ResponseEntity.ok(response);
    }
}
