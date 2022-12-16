package pfig3.bookingg3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfig3.bookingg3.model.dto.RuleCategoryDTO;
import pfig3.bookingg3.model.service.IRuleCategoryService;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/rule_category")
public class RuleCategoryController {
    @Autowired
    private IRuleCategoryService ruleCategoryService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> response = new HashMap<>();
        response.put("response",ruleCategoryService.findAll());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody RuleCategoryDTO ruleCategory){
        Map<String, Object> response = new HashMap<>();
        response.put("response",ruleCategoryService.save(ruleCategory));
        return ResponseEntity.created(URI.create("/api/v1/category")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody RuleCategoryDTO ruleCategory, @PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        response.put("response",ruleCategoryService.update(ruleCategory, id));
        return ResponseEntity.created(URI.create("/api/v1/rule_category")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", ruleCategoryService.findById(id));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", ruleCategoryService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }
}


