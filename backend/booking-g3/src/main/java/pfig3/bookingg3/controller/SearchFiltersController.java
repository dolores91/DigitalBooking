package pfig3.bookingg3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pfig3.bookingg3.model.dto.SearchFilterDTO;
import pfig3.bookingg3.model.entity.Product;
import pfig3.bookingg3.model.service.ISearchFilterService;
import pfig3.bookingg3.model.service.SearchFilterServiceImpl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/search_filter")
public class SearchFiltersController {

    @Autowired
    private ISearchFilterService searchFilterService;

    // Receives Date and City to filter availability. If the products are booked in the dates and cities picked by user.
    // These products won't filter or show.
    // We've given the user only the available products for them to book.

    @GetMapping("/{checkInDate}/{checkOutDate}")
    public ResponseEntity<Map<String, Object>> findProductByDates(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkInDate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOutDate) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", searchFilterService.findProductByDates(checkInDate, checkOutDate));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/city_dates")
    public ResponseEntity<Map<String, Object>> findProductByCityAndDates(@RequestBody SearchFilterDTO filter) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", searchFilterService.findProductByCityAndDates(filter.getCity().getId(), filter.getCheckInDate(), filter.getCheckOutDate()));
        return ResponseEntity.ok(response);
    }



    @GetMapping("/city_dates/{cityId}/{checkInDate}/{checkOutDate}")
    public ResponseEntity<Map<String, Object>> findProductByCityAndDates(@PathVariable Long cityId, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkInDate, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOutDate) {
        Map<String, Object> response = new HashMap<>();
        response.put("response", searchFilterService.findProductByCityAndDates(cityId, checkInDate, checkOutDate));
        return ResponseEntity.ok(response);
    }




}
