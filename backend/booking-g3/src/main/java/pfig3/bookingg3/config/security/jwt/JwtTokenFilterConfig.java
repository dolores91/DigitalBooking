package pfig3.bookingg3.config.security.jwt;

import pfig3.bookingg3.model.service.jwt.UserDetailsServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilterConfig  extends OncePerRequestFilter {

    @Autowired
    private JwtProviderConfig jwtProviderConfig;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    //Method: filters requests and validates if it's allowed or not the access to the resource before it reaches it
    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = myToken(request);
        if (token != null && jwtProviderConfig.validateToken(token)) {
            //Starts to check if token has permissions for entering the resource. Does it have expire time and date updated?. Checks integrity.

            String username = jwtProviderConfig.getUserNameFromToken(token);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }


    //BackUp Method to obtain the token that's being sent from the frontEnd. It replaces the bearer by an empty "". To get just the token.
    private String myToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer")) {
            return header.replace("Bearer ", "");
        }
        return null;
    }
}
