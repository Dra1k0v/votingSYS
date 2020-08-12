package bg.softuni.votingSysV2.entity;

import bg.softuni.votingSysV2.service.enums.UserRole;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    private UserRole role;

    public Role() {
    }

    public Role(UserRole role) {
        this.role = role;
    }

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

}
