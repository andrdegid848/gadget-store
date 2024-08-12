package org.gusev.gadgetstore.mapper;

import org.gusev.gadgetstore.database.entity.Monitor;
import org.gusev.gadgetstore.dto.monitor.MonitorCreateEditDto;
import org.gusev.gadgetstore.dto.monitor.MonitorReadDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MonitorMapper {

    @Mapping(target = "id", ignore = true)
    Monitor toEntity(MonitorCreateEditDto dto);

    MonitorReadDto toDto(Monitor monitor);
}
