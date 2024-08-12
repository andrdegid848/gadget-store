package org.gusev.gadgetstore.service;

import lombok.RequiredArgsConstructor;
import org.gusev.gadgetstore.database.repository.LaptopRepository;
import org.gusev.gadgetstore.dto.laptop.LaptopCreateEditDto;
import org.gusev.gadgetstore.dto.laptop.LaptopReadDto;
import org.gusev.gadgetstore.mapper.LaptopMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LaptopService {

    private final LaptopRepository laptopRepository;
    private final LaptopMapper laptopMapper;

    public List<LaptopReadDto> findAll() {
        return laptopRepository.findAll().stream()
                .map(laptopMapper::toDto)
                .toList();
    }

    public Optional<LaptopReadDto> findById(Long id) {
        return laptopRepository.findById(id)
                .map(laptopMapper::toDto);
    }

    @Transactional
    public LaptopReadDto create(LaptopCreateEditDto dto) {
        return Optional.of(dto)
                .map(laptopMapper::toEntity)
                .map(laptopRepository::save)
                .map(laptopMapper::toDto)
                .orElseThrow();
    }

    @Transactional
    public Optional<LaptopReadDto> update(Long id, LaptopCreateEditDto dto) {
        return laptopRepository.findById(id)
                .map(laptop -> laptopMapper.toEntity(dto))
                .map(laptopRepository::saveAndFlush)
                .map(laptopMapper::toDto);
    }
}