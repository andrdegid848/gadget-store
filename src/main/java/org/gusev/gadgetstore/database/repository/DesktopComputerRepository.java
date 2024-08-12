package org.gusev.gadgetstore.database.repository;

import org.gusev.gadgetstore.database.entity.desktop.DesktopComputer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesktopComputerRepository extends JpaRepository<DesktopComputer, Long> {

}
