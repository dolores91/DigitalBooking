package pfig3.bookingg3.exceptions;
import io.jsonwebtoken.ExpiredJwtException;

import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ExceptionsHandler {


    //Error for NotContentException
    @ExceptionHandler({MalformedJwtException.class, UnsupportedJwtException.class, ExpiredJwtException.class, SignatureException.class})
    public ResponseEntity<Map<String, Object>> notContentException(Exception e) {
        log.info(e.getClass().getName());
        log.info(e.getMessage());
        Map<String, Object> response = new HashMap<>();
        response.put("response", "Failed to validate jwt ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    //ERROR for BadRequestException
    @ExceptionHandler({IllegalArgumentException.class, ConstraintViolationException.class
            , MissingRequestHeaderException.class})
    public ResponseEntity<Map<String, Object>> batRequestException(Exception e) {
        log.info(e.getClass().getName());
        log.info(e.getMessage());
        Map<String, Object> response = new HashMap<>();
        response.put("response", "Error, the request is illegal ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    //Error for INTERNAL_SERVER_ERROR  [@param e @return]

    @ExceptionHandler({Exception.class, RuntimeException.class,
            IOException.class, ParseException.class, SocketTimeoutException.class})
    public final ResponseEntity<Map<String, Object>> exceptionsGeneral(Exception e) {
        log.info(e.getClass().getName());
        log.error(e.getMessage());
        Map<String, Object> response = new HashMap<>();
        response.put("response", "Error, Internal server error ".concat(e.getMessage()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
