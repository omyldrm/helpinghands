package be.kdg.pro3.helpinghands.presentation.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class VolunteerForm {

    @NotBlank(message = "{validation.volunteer.firstName.notblank}")
    @Size(min = 2, max = 50, message = "{validation.volunteer.firstName.size}")
    private String firstName;

    @NotBlank(message = "{validation.volunteer.lastName.notblank}")
    @Size(min = 2, max = 50, message = "{validation.volunteer.lastName.size}")
    private String lastName;

    @NotBlank(message = "{validation.volunteer.email.notblank}")
    @Email(message = "{validation.volunteer.email.invalid}")
    private String email;

    public VolunteerForm() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}