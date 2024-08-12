package org.gusev.gadgetstore.http.controller;

import lombok.RequiredArgsConstructor;
import org.gusev.gadgetstore.dto.desktop.DesktopComputerCreateEditDto;
import org.gusev.gadgetstore.dto.desktop.DesktopComputerReadDto;
import org.gusev.gadgetstore.service.DesktopComputerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/desktop-computers")
@RequiredArgsConstructor
public class DesktopComputerRestController {

    private final DesktopComputerService desktopComputerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DesktopComputerReadDto> findAll() {
        return desktopComputerService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DesktopComputerReadDto> findById(@PathVariable Long id) {
        return desktopComputerService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DesktopComputerReadDto> create(@Validated @RequestBody DesktopComputerCreateEditDto dto) {
        DesktopComputerReadDto createdDesktopComputer = desktopComputerService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDesktopComputer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesktopComputerReadDto> update(@PathVariable Long id,
                                                         @Validated @RequestBody DesktopComputerCreateEditDto dto) {
        return desktopComputerService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}