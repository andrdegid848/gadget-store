package org.gusev.gadgetstore.service;

import lombok.RequiredArgsConstructor;
import org.gusev.gadgetstore.database.repository.HDDRepository;
import org.gusev.gadgetstore.dto.hdd.HDDCreateEditDto;
import org.gusev.gadgetstore.dto.hdd.HDDReadDto;
import org.gusev.gadgetstore.mapper.HDDMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class HDDService {

    private final HDDRepository hddRepository;
    private final HDDMapper hddMapper;

    public List<HDDReadDto> findAll() {
        return hddRepository.findAll().stream()
                .map(hddMapper::toDto)
                .toList();
    }

    public Optional<HDDReadDto> findById(Long id) {
        return hddRepository.findById(id)
                .map(hddMapper::toDto);
    }

    @Transactional
    public HDDReadDto create(HDDCreateEditDto dto) {
        return Optional.of(dto)
                .map(hddMapper::toEntity)
                .map(hddRepository::save)
                .map(hddMapper::toDto)
                .orElseThrow();
    }

    @Transactional
    public Optional<HDDReadDto> update(Long id, HDDCreateEditDto dto) {
        return hddRepository.findById(id)
                .map(hdd -> hddMapper.toEntity(dto))
                .map(hddRepository::saveAndFlush)
                .map(hddMapper::toDto);
    }
}