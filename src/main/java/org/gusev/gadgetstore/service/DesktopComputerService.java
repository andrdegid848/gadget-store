package org.gusev.gadgetstore.service;

import lombok.RequiredArgsConstructor;
import org.gusev.gadgetstore.database.repository.DesktopComputerRepository;
import org.gusev.gadgetstore.dto.desktop.DesktopComputerCreateEditDto;
import org.gusev.gadgetstore.dto.desktop.DesktopComputerReadDto;
import org.gusev.gadgetstore.mapper.DesktopComputerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DesktopComputerService {

    private final DesktopComputerRepository desktopComputerRepository;
    private final DesktopComputerMapper desktopComputerMapper;

    public List<DesktopComputerReadDto> findAll() {
        return desktopComputerRepository.findAll().stream()
                .map(desktopComputerMapper::toDto)
                .toList();
    }

    public Optional<DesktopComputerReadDto> findById(Long id) {
        return desktopComputerRepository.findById(id)
                .map(desktopComputerMapper::toDto);
    }

    @Transactional
    public DesktopComputerReadDto create(DesktopComputerCreateEditDto dto) {
        return Optional.of(dto)
                .map(desktopComputerMapper::toEntity)
                .map(desktopComputerRepository::save)
                .map(desktopComputerMapper::toDto)
                .orElseThrow();
    }

    @Transactional
    public Optional<DesktopComputerReadDto> update(Long id, DesktopComputerCreateEditDto dto) {
        return desktopComputerRepository.findById(id)
                .map(desktop -> desktopComputerMapper.toEntity(dto))
                .map(desktopComputerRepository::saveAndFlush)
                .map(desktopComputerMapper::toDto);
    }
}