package bg.softuni.votingSysV2.dto;

public class PartyStatisticDTO {
    private String name;
    private int voteCount;

    public PartyStatisticDTO(String name, int voteCount) {
        this.name = name;
        this.voteCount = voteCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
