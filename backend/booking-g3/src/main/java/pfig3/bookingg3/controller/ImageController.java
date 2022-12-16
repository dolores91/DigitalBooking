package pfig3.bookingg3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfig3.bookingg3.model.dto.ImageDTO;
import pfig3.bookingg3.model.service.IImageService;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/image")
public class ImageController {

    @Autowired
    private IImageService imageService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> response = new HashMap<>();
        response.put("response", imageService.findAll());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", imageService.findById(id));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Map<String, Object>> findByProductId(@PathVariable Long productId) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", imageService.findByProductId(productId));
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody ImageDTO image) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", imageService.save(image));
        return ResponseEntity.created(URI.create("/api/v1/image")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody ImageDTO image, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", imageService.update(image, id));
        return ResponseEntity.created(URI.create("/api/v1/image")).body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", imageService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }

}




