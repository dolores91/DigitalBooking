package pfig3.bookingg3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfig3.bookingg3.model.dto.ProductRuleDTO;
import pfig3.bookingg3.model.service.IProductRuleService;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/product_rule")
public class ProductRuleController {
    @Autowired
    private IProductRuleService productRuleService;

    @GetMapping
    public ResponseEntity<Map<String,Object>> index(){
        Map<String, Object> response = new HashMap<>();
        response.put("response", productRuleService.findAll());
        return ResponseEntity.ok(response);
    }


    @GetMapping("/product/{productId}")
    public ResponseEntity<Map<String, Object>> findRuleByProduct(@PathVariable Long productId) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", productRuleService.findRuleByProduct(productId));
        return ResponseEntity.ok(response);
    }


    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody ProductRuleDTO productRule){
        Map<String, Object> response = new HashMap<>();
        response.put("response",productRuleService.save(productRule));
        return ResponseEntity.created(URI.create("/api/v1/product_rule")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody ProductRuleDTO productRule, @PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        response.put("response",productRuleService.update(productRule, id));
        return ResponseEntity.created(URI.create("/api/v1/product_rule")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", productRuleService.findById(id));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", productRuleService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }
}
