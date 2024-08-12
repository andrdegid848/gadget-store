package org.gusev.gadgetstore.dto.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseProductCreateEditDto {

    @Size(min = 7, max = 20)
    @NotBlank(message = "Serial number is required")
    private String serialNumber;

    @Size(min = 3, max = 35)
    @NotBlank(message = "Manufacturer is required")
    private String manufacturer;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero")
    private BigDecimal price;

    @NotNull(message = "Stock is required")
    @Min(value = 0, message = "Stock must be non-negative")
    private Integer stock;
}
