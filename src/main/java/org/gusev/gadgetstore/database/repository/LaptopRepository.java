package org.gusev.gadgetstore.database.repository;

import org.gusev.gadgetstore.database.entity.laptop.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
