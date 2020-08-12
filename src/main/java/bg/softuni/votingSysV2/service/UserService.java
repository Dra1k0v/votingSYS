package bg.softuni.votingSysV2.service;

import bg.softuni.votingSysV2.dto.RegistrationDTO;
import bg.softuni.votingSysV2.entity.User;


public interface UserService {

    void registerUser(RegistrationDTO registrationDTO);

    void vote(User user, Long partyId);
}
