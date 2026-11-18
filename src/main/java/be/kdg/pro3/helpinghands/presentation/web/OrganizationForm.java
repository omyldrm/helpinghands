package be.kdg.pro3.helpinghands.presentation.web;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class OrganizationForm {

    @NotBlank(message = "{validation.organization.name.notblank}")
    @Size(min = 2, max = 100, message = "{validation.organization.name.size}")
    private String name;

    @NotNull(message = "{validation.organization.foundedDate.notnull}")
    @PastOrPresent(message = "{validation.organization.foundedDate.past}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate foundedDate;

    @NotNull(message = "{validation.organization.averageRating.notnull}")
    @DecimalMin(value = "0.0", message = "{validation.organization.averageRating.min}")
    @DecimalMax(value = "5.0", message = "{validation.organization.averageRating.max}")
    private Double averageRating;

    private boolean isVerified;

    private String logoUrl;

    public OrganizationForm(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(LocalDate foundedDate) {
        this.foundedDate = foundedDate;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}