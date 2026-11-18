package be.kdg.pro3.helpinghands.presentation.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private boolean student;

    private String avatarUrl;

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}