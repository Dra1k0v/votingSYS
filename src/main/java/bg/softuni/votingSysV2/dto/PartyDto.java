package bg.softuni.votingSysV2.dto;

import javax.validation.constraints.NotBlank;

public class PartyDto {
    @NotBlank
    private String name;

    public PartyDto(String name) {
        this.name = name;
    }

    public PartyDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
