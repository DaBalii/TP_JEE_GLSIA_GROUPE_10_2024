
package iaiglsia.tp_hr.Services;

import java.util.List;

import iaiglsia.tp_hr.Repository.IRoleRepository;
import iaiglsia.tp_hr.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import jakarta.transaction.Transactional;

@Service
@Transactional
public class WRoleService {
	private static final Logger LOG = LoggerFactory.getLogger(WRoleService.class);

	@Autowired
	private IRoleRepository roleReposiroty;

	public Role save(Role role) {
		return roleReposiroty.save(role);
	}

	public List<Role> findAllRole() {
		return roleReposiroty.findAll();
	}

	public Role findDefaultRole() {
		return findAllRole().stream().findFirst().orElse(null);
	}

	public Role findRoleByName(String role) {
		return findAllRole().stream().filter(r -> r.getName().equals(role)).findFirst().orElse(null);
	}

}
