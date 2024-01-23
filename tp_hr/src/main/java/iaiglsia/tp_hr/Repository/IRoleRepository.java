package iaiglsia.tp_hr.Repository;

import iaiglsia.tp_hr.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>{
	Role findByName(String name);



}
