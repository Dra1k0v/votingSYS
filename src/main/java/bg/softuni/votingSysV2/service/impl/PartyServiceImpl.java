package bg.softuni.votingSysV2.service.impl;

import bg.softuni.votingSysV2.dto.PartyDto;
import bg.softuni.votingSysV2.dto.PartyStatisticDTO;
import bg.softuni.votingSysV2.entity.Party;
import bg.softuni.votingSysV2.repository.PartyRepository;
import bg.softuni.votingSysV2.repository.RoleRepository;
import bg.softuni.votingSysV2.repository.UserRepository;
import bg.softuni.votingSysV2.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartyServiceImpl implements PartyService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PartyRepository partyRepository;

    @Autowired
    public PartyServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PartyRepository partyRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.partyRepository = partyRepository;
    }


    @Override
    public List<Party> getAllParties() {
        return partyRepository.findAll();
    }

    @Override
    public void addParty(PartyDto partyDto) {
        partyRepository.saveAndFlush(new Party(partyDto.getName()));
    }

    @Override
    public boolean exists(PartyDto partyDto) {
        return partyRepository.existsByName(partyDto.getName());
    }

    @Override
    @Transactional
    public void deleteById(Long partyId) {
        Party party = partyRepository.findById(partyId).get();

        party.getVoters().forEach(user -> {
            user.setParty(null);
        });

        userRepository.saveAll(party.getVoters());
        userRepository.flush();

        party.getVoters().clear();

        partyRepository.deleteById(partyId);
        partyRepository.flush();
    }

    @Override
    public List<PartyStatisticDTO> getPartyStatistics() {
        return partyRepository.findAll().stream()
                .map(party -> new PartyStatisticDTO(party.getName(), party.getVoters().size()))
                .collect(Collectors.toList());
    }
}
