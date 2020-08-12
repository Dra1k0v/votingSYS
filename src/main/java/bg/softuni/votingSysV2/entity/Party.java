package bg.softuni.votingSysV2.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "parties")
public class Party extends BaseEntity{

    private String name;
    private Collection<User> voters;

    public Party() {
    }

    public Party(String name) {
        this.name = name;
    }

    @Column(name = "party_name", unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "party", targetEntity = User.class, fetch = FetchType.EAGER)
    public Collection<User> getVoters() {
        return voters;
    }

    public void setVoters(Collection<User> voters) {
        this.voters = voters;
    }
}
