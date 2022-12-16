package pfig3.bookingg3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfig3.bookingg3.model.dto.AttributeDTO;
import pfig3.bookingg3.model.service.IAttributeService;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/attribute")
public class AttributeController {

    @Autowired
    private IAttributeService attributeService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> response = new HashMap<>();
        response.put("response", attributeService.findAll());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody AttributeDTO attribute) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", attributeService.save(attribute));
        return ResponseEntity.created(URI.create("/api/v1/attribute")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody AttributeDTO attribute, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", attributeService.update(attribute, id));
        return ResponseEntity.created(URI.create("/api/v1/attribute")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", attributeService.findById(id));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", attributeService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }
}