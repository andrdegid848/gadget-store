package org.gusev.gadgetstore.database.entity.desktop;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.gusev.gadgetstore.database.entity.BaseProduct;


@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DesktopComputer extends BaseProduct {

    @Enumerated(EnumType.STRING)
    private FormFactor formFactor;
}
