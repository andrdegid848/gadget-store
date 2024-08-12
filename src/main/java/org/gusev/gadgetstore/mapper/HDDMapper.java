package org.gusev.gadgetstore.mapper;

import org.gusev.gadgetstore.database.entity.HDD;
import org.gusev.gadgetstore.dto.hdd.HDDCreateEditDto;
import org.gusev.gadgetstore.dto.hdd.HDDReadDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HDDMapper {

    @Mapping(target = "id", ignore = true)
    HDD toEntity(HDDCreateEditDto dto);

    HDDReadDto toDto(HDD hdd);
}
