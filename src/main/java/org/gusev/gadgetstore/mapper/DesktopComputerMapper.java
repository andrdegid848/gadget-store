package org.gusev.gadgetstore.mapper;

import org.gusev.gadgetstore.database.entity.desktop.DesktopComputer;
import org.gusev.gadgetstore.dto.desktop.DesktopComputerCreateEditDto;
import org.gusev.gadgetstore.dto.desktop.DesktopComputerReadDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DesktopComputerMapper {

    @Mapping(target = "id", ignore = true)
    DesktopComputer toEntity(DesktopComputerCreateEditDto dto);

    DesktopComputerReadDto toDto(DesktopComputer desktop);
}
