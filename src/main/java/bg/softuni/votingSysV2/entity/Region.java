package bg.softuni.votingSysV2.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "region")
public class Region extends BaseEntity {

    private String name;

    public Region() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
