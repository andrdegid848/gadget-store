package org.gusev.gadgetstore.http.controller;

import lombok.RequiredArgsConstructor;
import org.gusev.gadgetstore.dto.hdd.HDDCreateEditDto;
import org.gusev.gadgetstore.dto.hdd.HDDReadDto;
import org.gusev.gadgetstore.service.HDDService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hdds")
@RequiredArgsConstructor
public class HDDRestController {

    private final HDDService hddService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HDDReadDto> findAll() {
        return hddService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HDDReadDto> findById(@PathVariable Long id) {
        return hddService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HDDReadDto> create(@Validated @RequestBody HDDCreateEditDto dto) {
        HDDReadDto createdHdd = hddService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHdd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HDDReadDto> update(@PathVariable Long id,
                                             @Validated @RequestBody HDDCreateEditDto dto) {
        return hddService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
