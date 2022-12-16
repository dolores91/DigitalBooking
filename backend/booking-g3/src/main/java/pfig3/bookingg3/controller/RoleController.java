package pfig3.bookingg3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfig3.bookingg3.model.dto.jwt.RoleDTO;
import pfig3.bookingg3.model.service.jwt.IRoleService;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> response = new HashMap<>();
        response.put("response", roleService.findAll());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody RoleDTO role) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", roleService.save(role));
        return ResponseEntity.created(URI.create("/api/v1/role")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody RoleDTO role, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", roleService.update(role, id));
        return ResponseEntity.created(URI.create("/api/v1/role")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", roleService.findById(id));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", roleService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }

}
