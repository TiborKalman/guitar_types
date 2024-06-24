package website.kalman.guitar_types.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import website.kalman.guitar_types.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByUsername(String username);
    Boolean existsByEmailAccount(String email);

    Optional<User> findByName(String u);
    Optional<User> findByUsername(String u);
    Optional<User> findByEmailAccount(String u);


}
