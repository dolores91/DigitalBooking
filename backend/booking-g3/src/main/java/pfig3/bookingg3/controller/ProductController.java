package pfig3.bookingg3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfig3.bookingg3.model.dto.ProductDTO;
import pfig3.bookingg3.model.service.IProductService;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    //method to paginate the information from the db without altering our deliveries.
    // Method's function is based in a page number that begins with 0 (it's an array) and an amount of data to show
    //Page and numData. With this we use an interface from CrudRepository that's implemented under a PageRequest. The object receives
    // the page number and the number of number of data to show.

    @GetMapping("/{page}/{numData}")
    public ResponseEntity<Map<String, Object>> indexPageable(@PathVariable Integer page, @PathVariable Integer numData){
        Map<String, Object> response = new HashMap<>();
        response.put("response", productService.findAll(PageRequest.of(page,numData)));
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<Map<String, Object>> index() {
        Map<String, Object> response = new HashMap<>();
        List<ProductDTO> list = productService.findAll();
        Collections.shuffle(list);
        response.put("response", list);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody ProductDTO product) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", productService.save(product));
        return ResponseEntity.created(URI.create("/api/v1/product")).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody ProductDTO product, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", productService.update(product, id));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", productService.findById(id));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", productService.delete(id));
        return ResponseEntity.noContent().build();//(response);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Map<String, Object>> findByCategory(@PathVariable Long categoryId) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", productService.findByCategory(categoryId));
        return ResponseEntity.ok(response);
    }


    @GetMapping("/city/{cityId}")
    public ResponseEntity<Map<String, Object>> findByCity(@PathVariable Long cityId) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", productService.findByCity(cityId));
        return ResponseEntity.ok(response);
    }


}
