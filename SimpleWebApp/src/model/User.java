package model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

    @Column(name = "authToken", nullable = false)
    private String authToken;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "positionOnStarship", nullable = false, columnDefinition = "TEXT")
    private String positionOnStarship;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private int balance;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String background;

    @Column(name = "publicBackground", nullable = false, columnDefinition = "TEXT")
    private String publicBackground;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String photo;

    @Column(name = "securityBackground", nullable = false, columnDefinition = "TEXT")
    private String securityBackground;

    @Column(name = "medicalBackground", nullable = false, columnDefinition = "TEXT")
    private String medicalBackground;

    @Column(name = "psychologyBackground", nullable = false, columnDefinition = "TEXT")
    private String psychologyBackground;

    @Column(name = "lastAvailable", nullable = false)
    private int lastAvailable;

    @Column(name = "userSettings", nullable = false)
    private int userSettings;

    // Добавляем сеттеры для каждого поля
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPositionOnStarship(String positionOnStarship) {
        this.positionOnStarship = positionOnStarship;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setPublicBackground(String publicBackground) {
        this.publicBackground = publicBackground;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setSecurityBackground(String securityBackground) {
        this.securityBackground = securityBackground;
    }

    public void setMedicalBackground(String medicalBackground) {
        this.medicalBackground = medicalBackground;
    }

    public void setPsychologyBackground(String psychologyBackground) {
        this.psychologyBackground = psychologyBackground;
    }

    public void setLastAvailable(int lastAvailable) {
        this.lastAvailable = lastAvailable;
    }

    public void setUserSettings(int userSettings) {
        this.userSettings = userSettings;
    }

    // Геттеры для каждого поля
    public int getUserId() {
        return userId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getUserName() {
        return userName;
    }

    public String getPositionOnStarship() {
        return positionOnStarship;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public int getBalance() {
        return balance;
    }

    public String getBackground() {
        return background;
    }

    public String getPublicBackground() {
        return publicBackground;
    }

    public String getPhoto() {
        return photo;
    }

    public String getSecurityBackground() {
        return securityBackground;
    }

    public String getMedicalBackground() {
        return medicalBackground;
    }

    public String getPsychologyBackground() {
        return psychologyBackground;
    }

    public int getLastAvailable() {
        return lastAvailable;
    }

    public int getUserSettings() {
        return userSettings;
    }

}
