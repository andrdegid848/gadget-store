package org.gusev.gadgetstore.http.controller;

import lombok.RequiredArgsConstructor;
import org.gusev.gadgetstore.dto.monitor.MonitorCreateEditDto;
import org.gusev.gadgetstore.dto.monitor.MonitorReadDto;
import org.gusev.gadgetstore.service.MonitorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/monitors")
@RequiredArgsConstructor
public class MonitorRestController {

    private final MonitorService monitorService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonitorReadDto> findAll() {
        return monitorService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MonitorReadDto> findById(@PathVariable Long id) {
        return monitorService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MonitorReadDto> create(@Validated @RequestBody MonitorCreateEditDto dto) {
        MonitorReadDto createdMonitor = monitorService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMonitor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonitorReadDto> update(@PathVariable Long id,
                                                 @Validated @RequestBody MonitorCreateEditDto dto) {
        return monitorService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
