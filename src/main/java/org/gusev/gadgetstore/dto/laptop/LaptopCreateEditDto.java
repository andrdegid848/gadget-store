package org.gusev.gadgetstore.dto.laptop;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.gusev.gadgetstore.database.entity.laptop.ScreenSize;
import org.gusev.gadgetstore.dto.product.BaseProductCreateEditDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LaptopCreateEditDto extends BaseProductCreateEditDto {

    @NotNull(message = "Screen size is required")
    private ScreenSize screenSize;
}
