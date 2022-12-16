package pfig3.bookingg3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfig3.bookingg3.model.dto.RuleDTO;
import pfig3.bookingg3.model.service.IRuleService;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/rule")
public class RuleController {

    @Autowired
    private IRuleService ruleService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> response = new HashMap<>();
        response.put("response", ruleService.findAll());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody RuleDTO rule) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", ruleService.save(rule));
        return ResponseEntity.created(URI.create("/api/v1/rule")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody RuleDTO rule, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", ruleService.update(rule, id));
        return ResponseEntity.created(URI.create("/api/v1/rule")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", ruleService.findById(id));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/category/{ruleCategoryId}")
    public ResponseEntity<Map<String, Object>> findByRuleCategory(@PathVariable Long ruleCategoryId) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", ruleService.findByRuleCategory(ruleCategoryId));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", ruleService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }

}
