package bg.softuni.votingSysV2.service.impl;

import bg.softuni.votingSysV2.dto.RegistrationDTO;
import bg.softuni.votingSysV2.entity.User;
import bg.softuni.votingSysV2.repository.PartyRepository;
import bg.softuni.votingSysV2.repository.RoleRepository;
import bg.softuni.votingSysV2.repository.TownRepository;
import bg.softuni.votingSysV2.repository.UserRepository;
import bg.softuni.votingSysV2.service.UserService;
import bg.softuni.votingSysV2.service.enums.UserRole;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PartyRepository partyRepository;
    private final ModelMapper modelMapper;
    private final TownRepository townRepository;
    private final RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, PartyRepository partyRepository, ModelMapper modelMapper, TownRepository townRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.partyRepository = partyRepository;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(RegistrationDTO registrationDTO) {

        User user = new User();
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setPersonalIdNum(Long.parseLong(registrationDTO.getPersonalIdNumber()));
        user.setTown(townRepository.findByName(registrationDTO.getTown()).get());
        user.setRole(roleRepository.findByRole(UserRole.ROLE_USER));

        userRepository.saveAndFlush(user);
    }

    @Override
    public void vote(User user, Long partyId) {
        user.setParty(partyRepository.findById(partyId).get());
        userRepository.saveAndFlush(user);
    }

}
