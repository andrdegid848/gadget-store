package org.gusev.gadgetstore.dto.hdd;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.gusev.gadgetstore.dto.product.BaseProductCreateEditDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HDDCreateEditDto extends BaseProductCreateEditDto {

    @NotNull(message = "Capacity is required")
    @DecimalMin(value = "0", inclusive = false, message = "Capacity must be positive")
    private Integer capacity;
}
