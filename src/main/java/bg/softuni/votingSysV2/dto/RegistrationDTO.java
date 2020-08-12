package bg.softuni.votingSysV2.dto;

import bg.softuni.votingSysV2.validation.FieldMatch;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@JsonIgnoreProperties(ignoreUnknown = true)
@FieldMatch(first = "password", second = "confirmPassword")
public class RegistrationDTO {

    private String email;
    private String password;
    private String confirmPassword;
    private String personalIdNumber;
    private String firstName;
    private String lastName;
    private String town;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String email, String password, String confirmPassword, String personalIdNumber, String firstName, String lastName, String town) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.personalIdNumber = personalIdNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.town = town;
    }

    @Email
    @NotBlank
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank
    @NumberFormat
    public String getPersonalIdNumber() {
        return personalIdNumber;
    }

    public void setPersonalIdNumber(String personalIdNumber) {
        this.personalIdNumber = personalIdNumber;
    }

    @NotBlank
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotBlank
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotBlank
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @NotBlank
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", personalIdNumber='" + personalIdNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", town='" + town + '\'' +
                '}';
    }
}
