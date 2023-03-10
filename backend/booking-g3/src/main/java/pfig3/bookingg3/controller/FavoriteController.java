package pfig3.bookingg3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfig3.bookingg3.model.dto.FavoriteDTO;
import pfig3.bookingg3.model.service.IFavoriteService;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/favorite")
public class FavoriteController {
    @Autowired
    private IFavoriteService favoriteService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> response = new HashMap<>();
        response.put("response", favoriteService.findAll());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody FavoriteDTO favorite) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", favoriteService.save(favorite));
        return ResponseEntity.created(URI.create("/api/v1/favorite")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody FavoriteDTO favorite, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", favoriteService.update(favorite, id));
        return ResponseEntity.created(URI.create("/api/v1/favorite")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", favoriteService.findById(id));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", favoriteService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }
}
