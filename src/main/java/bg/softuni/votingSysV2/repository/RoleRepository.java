package bg.softuni.votingSysV2.repository;

import bg.softuni.votingSysV2.entity.Role;
import bg.softuni.votingSysV2.service.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(UserRole role);
}
