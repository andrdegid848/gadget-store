package org.gusev.gadgetstore.dto.monitor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.gusev.gadgetstore.dto.product.BaseProductReadDto;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MonitorReadDto extends BaseProductReadDto {
    private BigDecimal diagonal;
}
