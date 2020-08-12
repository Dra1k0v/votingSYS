package bg.softuni.votingSysV2.init;

import bg.softuni.votingSysV2.entity.*;
import bg.softuni.votingSysV2.repository.*;
import bg.softuni.votingSysV2.service.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TownRepository townRepository;
    private final RoleRepository roleRepository;
    private final RegionRepository regionRepository;
    private final PartyRepository partyRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public DataInit(UserRepository userRepository, TownRepository townRepository, RoleRepository roleRepository, RegionRepository regionRepository, PartyRepository partyRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.townRepository = townRepository;
        this.roleRepository = roleRepository;
        this.regionRepository = regionRepository;
        this.partyRepository = partyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Initializing data...");
        if (regionRepository.count() == 0){

            Region region = new Region();
            region.setName("C");
            regionRepository.saveAndFlush(region);
        }

        if (townRepository.count() == 0) {

            Town town = new Town();
            town.setName("Sofia");
            town.setRegion(regionRepository.findByName("C"));
            townRepository.saveAndFlush(town);
        }

        if (roleRepository.count() == 0){

            roleRepository.saveAll(List.of(
                    new Role(UserRole.ROLE_USER),
                    new Role(UserRole.ROLE_ADMIN)
            ));
            roleRepository.flush();
        }

        if (userRepository.count() == 0) {

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            User admin = new User();
            admin.setEmail("admin@admin.bg");
            admin.setFirstName("Admin");
            admin.setLastName("Admin");
            admin.setPassword(passwordEncoder.encode("topsecret"));
            admin.setPersonalIdNum(200000010);
            admin.setTown(townRepository.getOne((long) 1));
            admin.setRole(roleRepository.findByRole(UserRole.ROLE_ADMIN));


            User user = new User();
            user.setEmail("user@user.bg");
            user.setFirstName("User");
            user.setLastName("User");
            user.setPassword(passwordEncoder.encode("topsecret"));
            user.setPersonalIdNum(200000020);
            user.setTown(townRepository.getOne((long) 1));
            user.setRole(roleRepository.findByRole(UserRole.ROLE_USER));

            userRepository.saveAll(List.of(admin, user));
            userRepository.flush();
        }

        if (partyRepository.count() == 0){

            partyRepository.saveAndFlush(new Party("EXAMPLE_PARTY"));
        }

    }
}
