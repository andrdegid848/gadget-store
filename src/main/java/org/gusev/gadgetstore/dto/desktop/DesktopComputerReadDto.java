package org.gusev.gadgetstore.dto.desktop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.gusev.gadgetstore.database.entity.desktop.FormFactor;
import org.gusev.gadgetstore.dto.product.BaseProductReadDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DesktopComputerReadDto extends BaseProductReadDto {
    private FormFactor formFactor;
}
