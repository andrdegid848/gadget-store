package org.gusev.gadgetstore.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseProductReadDto {
    private Long id;
    private String serialNumber;
    private String manufacturer;
    private BigDecimal price;
    private Integer stock;
}
