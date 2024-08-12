package org.gusev.gadgetstore.dto.monitor;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.gusev.gadgetstore.dto.product.BaseProductCreateEditDto;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MonitorCreateEditDto extends BaseProductCreateEditDto {

    @NotNull(message = "Diagonal is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Diagonal must be positive")
    private BigDecimal diagonal;
}
