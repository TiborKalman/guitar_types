package website.kalman.guitar_types.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import website.kalman.guitar_types.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
