package bg.softuni.votingSysV2.repository;

import bg.softuni.votingSysV2.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

    boolean existsByName(String name);
}
