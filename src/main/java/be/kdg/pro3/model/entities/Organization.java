package be.kdg.pro3.model.entities;

import java.time.LocalDate;

public class Organization {
    private Long id;
    private String name;
    private LocalDate foundedDate;
    private double averageRating;
    private boolean isVerified;
    private String logoUrl;

    public Organization() {
    }

    public Organization(String name, LocalDate foundedDate, double averageRating,
                        boolean isVerified, String logoUrl) {
        this.name = name;
        this.foundedDate = foundedDate;
        this.averageRating = averageRating;
        this.isVerified = isVerified;
        this.logoUrl = logoUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }
}
