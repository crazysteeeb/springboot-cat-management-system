package edu.missouristate.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cats")
public class Cats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "Integer")
    private Integer id;

    @Column(name = "breed", columnDefinition = "Varchar(64)")
    private String breed;

    @Column(name = "colorPattern", columnDefinition = "Varchar(64)")
    private String colorPattern;

    @Column(name = "eyeColor", columnDefinition = "VARCHAR(32)")
    private String eyeColor;

    @Column(name = "furLength", columnDefinition = "VARCHAR(32)")
    private String furLength;

    @Column(name = "personalityType", columnDefinition = "VARCHAR(64)")
    private String personalityType;

    @Column(name = "created_at" , columnDefinition = "DATETIME")
    private java.time.LocalDateTime createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColorPattern() {
        return colorPattern;
    }

    public void setColorPattern(String colorPattern) {
        this.colorPattern = colorPattern;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getFurLength() {
        return furLength;
    }

    public void setFurLength(String furLength) {
        this.furLength = furLength;
    }

    public String getPersonalityType() {
        return personalityType;
    }

    public void setPersonalityType(String personalityType) {
        this.personalityType = personalityType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
