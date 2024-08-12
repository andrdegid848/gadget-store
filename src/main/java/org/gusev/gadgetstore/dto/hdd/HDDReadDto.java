package org.gusev.gadgetstore.dto.hdd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.gusev.gadgetstore.dto.product.BaseProductReadDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HDDReadDto extends BaseProductReadDto {
    private Integer capacity;
}
