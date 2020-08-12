package bg.softuni.votingSysV2.repository;

import bg.softuni.votingSysV2.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    Region findByName(String name);
}
