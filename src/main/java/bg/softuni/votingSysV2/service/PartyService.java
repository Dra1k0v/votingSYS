package bg.softuni.votingSysV2.service;


import bg.softuni.votingSysV2.dto.PartyDto;
import bg.softuni.votingSysV2.dto.PartyStatisticDTO;
import bg.softuni.votingSysV2.entity.Party;

import java.util.List;

public interface PartyService {

    List<Party> getAllParties();

    void addParty(PartyDto partyDto);

    boolean exists(PartyDto partyDto);

    void deleteById(Long partyId);

    List<PartyStatisticDTO> getPartyStatistics();
}
