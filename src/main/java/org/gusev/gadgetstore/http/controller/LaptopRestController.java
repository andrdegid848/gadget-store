package org.gusev.gadgetstore.http.controller;

import lombok.RequiredArgsConstructor;
import org.gusev.gadgetstore.dto.laptop.LaptopCreateEditDto;
import org.gusev.gadgetstore.dto.laptop.LaptopReadDto;
import org.gusev.gadgetstore.service.LaptopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/laptops")
@RequiredArgsConstructor
public class LaptopRestController {

    private final LaptopService laptopService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LaptopReadDto> findAll() {
        return laptopService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LaptopReadDto> findById(@PathVariable Long id) {
        return laptopService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LaptopReadDto> create(@Validated @RequestBody LaptopCreateEditDto dto) {
        LaptopReadDto createdLaptop = laptopService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLaptop);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LaptopReadDto> update(@PathVariable Long id,
                                                @Validated @RequestBody LaptopCreateEditDto dto) {
        return laptopService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
