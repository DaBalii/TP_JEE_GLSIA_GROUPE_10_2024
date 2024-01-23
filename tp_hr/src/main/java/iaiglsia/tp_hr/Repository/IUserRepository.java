package iaiglsia.tp_hr.Repository;

import iaiglsia.tp_hr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findUserByUsernameAndPassword(String username, String password);
    
    User findByUsername(String username);
}
