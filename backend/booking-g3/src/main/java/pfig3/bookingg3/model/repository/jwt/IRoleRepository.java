package pfig3.bookingg3.model.repository.jwt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pfig3.bookingg3.model.entity.jwt.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
}
