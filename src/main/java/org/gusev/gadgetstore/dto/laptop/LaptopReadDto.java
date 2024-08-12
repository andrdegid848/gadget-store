package org.gusev.gadgetstore.dto.laptop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.gusev.gadgetstore.database.entity.laptop.ScreenSize;
import org.gusev.gadgetstore.dto.product.BaseProductReadDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LaptopReadDto extends BaseProductReadDto {
    private ScreenSize screenSize;
}
