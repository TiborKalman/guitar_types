package website.kalman.guitar_types.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import website.kalman.guitar_types.entity.GuitarType;

import java.util.UUID;

public interface GuitarTypeRepository extends JpaRepository<GuitarType, Long> {
}
