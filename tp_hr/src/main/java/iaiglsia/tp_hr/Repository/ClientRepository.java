package iaiglsia.tp_hr.Repository;

import iaiglsia.tp_hr.entity.client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<client,Long> {
}
