package pfig3.bookingg3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfig3.bookingg3.model.dto.ProductAttributeDTO;
import pfig3.bookingg3.model.service.IProductAttributeService;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/product_attribute")
public class ProductAttributeController {
    @Autowired
    private IProductAttributeService productAttributeService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> response = new HashMap<>();
        response.put("response",productAttributeService.findAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Map<String, Object>> findByProductId(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response",productAttributeService.findByProductId(id));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody ProductAttributeDTO productAttribute){
        Map<String, Object> response = new HashMap<>();
        response.put("response",productAttributeService.save(productAttribute));
        return ResponseEntity.created(URI.create("/api/v1/product_attribute")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody ProductAttributeDTO productAttribute, @PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        response.put("response",productAttributeService.update(productAttribute, id));
        return ResponseEntity.created(URI.create("/api/v1/product_attribute")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", productAttributeService.findById(id));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", productAttributeService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }
}
