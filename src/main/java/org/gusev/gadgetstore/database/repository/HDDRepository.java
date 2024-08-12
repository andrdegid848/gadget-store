package org.gusev.gadgetstore.database.repository;

import org.gusev.gadgetstore.database.entity.HDD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HDDRepository extends JpaRepository<HDD, Long> {
}
