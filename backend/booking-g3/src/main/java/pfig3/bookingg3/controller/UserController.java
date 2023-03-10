package pfig3.bookingg3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pfig3.bookingg3.model.dto.jwt.UserDTO;
import pfig3.bookingg3.model.service.jwt.IUserService;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<Map<String,Object>> index(){
        Map<String, Object> response = new HashMap<>();
        response.put("response", userService.findAll());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody UserDTO user) {
        Map<String, Object> response = new HashMap<>();
        String passWEncrypt = passwordEncoder.encode(user.getPassword());
        user.setPassword(passWEncrypt);
        response.put("response", userService.save(user));
        return ResponseEntity.created(URI.create("/api/v1/user")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody UserDTO user, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        String passWEncrypt = passwordEncoder.encode(user.getPassword());
        user.setPassword(passWEncrypt);
        response.put("response", userService.update(user, id));
        return ResponseEntity.created(URI.create("/api/v1/user")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", userService.findById(id));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", userService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }

}
