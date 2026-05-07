package sv.edu.uca.delivery.lab2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sv.edu.uca.delivery.lab2.dto.PirataDto;
import sv.edu.uca.delivery.lab2.entity.Pirata;
import sv.edu.uca.delivery.lab2.service.PirataService;

import java.util.UUID;

@RestController
@RequestMapping("/api/pirata")
@AllArgsConstructor
public class PirataController {
    private PirataService service;

    @PostMapping("/create")
    public ResponseEntity<Pirata> createProduct(@RequestBody PirataDto data){
        var response = service.create(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Pirata> getProduct(@PathVariable UUID id) {
        var data = service.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(data);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removedProduct(@PathVariable UUID id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("piara deleted successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Pirata> updateProduct(@PathVariable UUID id, @RequestBody PirataDto data){
        var update = service.update(id, data);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }
}
