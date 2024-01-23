package iaiglsia.tp_hr.Repository;

import java.util.List;

import iaiglsia.tp_hr.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;






@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole, Long>{
	
	List<UserRole> findAllByUserId(Long id);

}
