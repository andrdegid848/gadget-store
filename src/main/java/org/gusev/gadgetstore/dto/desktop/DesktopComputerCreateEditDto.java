package org.gusev.gadgetstore.dto.desktop;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.gusev.gadgetstore.database.entity.desktop.FormFactor;
import org.gusev.gadgetstore.dto.product.BaseProductCreateEditDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DesktopComputerCreateEditDto extends BaseProductCreateEditDto {

    @NotNull(message = "Form factor is required")
    private FormFactor formFactor;
}
