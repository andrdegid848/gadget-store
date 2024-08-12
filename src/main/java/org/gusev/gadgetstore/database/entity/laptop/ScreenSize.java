package org.gusev.gadgetstore.database.entity.laptop;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ScreenSize {
    INCH_13(13),
    INCH_14(14),
    INCH_15(15),
    INCH_17(17);

    private final Integer size;
}
