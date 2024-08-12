package org.gusev.gadgetstore.database.entity;

import java.io.Serializable;

public interface BaseEntity<T extends Serializable> {
    T getId();
}
