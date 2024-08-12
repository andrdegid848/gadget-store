package org.gusev.gadgetstore.mapper;

import org.gusev.gadgetstore.database.entity.laptop.Laptop;
import org.gusev.gadgetstore.dto.laptop.LaptopCreateEditDto;
import org.gusev.gadgetstore.dto.laptop.LaptopReadDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LaptopMapper {

    @Mapping(target = "id", ignore = true)
    Laptop toEntity(LaptopCreateEditDto dto);

    LaptopReadDto toDto(Laptop laptop);
}
