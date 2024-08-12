package org.gusev.gadgetstore.service;

import lombok.RequiredArgsConstructor;
import org.gusev.gadgetstore.database.repository.MonitorRepository;
import org.gusev.gadgetstore.dto.monitor.MonitorCreateEditDto;
import org.gusev.gadgetstore.dto.monitor.MonitorReadDto;
import org.gusev.gadgetstore.mapper.MonitorMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MonitorService {

    private final MonitorRepository monitorRepository;
    private final MonitorMapper monitorMapper;

    public List<MonitorReadDto> findAll() {
        return monitorRepository.findAll().stream()
                .map(monitorMapper::toDto)
                .toList();
    }

    public Optional<MonitorReadDto> findById(Long id) {
        return monitorRepository.findById(id)
                .map(monitorMapper::toDto);
    }

    @Transactional
    public MonitorReadDto create(MonitorCreateEditDto dto) {
        return Optional.of(dto)
                .map(monitorMapper::toEntity)
                .map(monitorRepository::save)
                .map(monitorMapper::toDto)
                .orElseThrow();
    }

    @Transactional
    public Optional<MonitorReadDto> update(Long id, MonitorCreateEditDto dto) {
        return monitorRepository.findById(id)
                .map(monitor -> monitorMapper.toEntity(dto))
                .map(monitorRepository::saveAndFlush)
                .map(monitorMapper::toDto);
    }
}