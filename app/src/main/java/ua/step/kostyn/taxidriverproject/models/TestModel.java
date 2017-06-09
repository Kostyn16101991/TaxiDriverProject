package ua.step.kostyn.taxidriverproject.models;

/**
 * Created by konstantin on 08.06.17.
 */

public class TestModel {
    private int ageUser;
    private int avatarUser;
    private String carModelDriver;
    private String emailUser;
    private double experienceDriver;
    private String lastNameUser;
    private String nameUser;
    private String numPlateCarDriver;
    private String passwordUser;
    private String phoneUser;
    private String sexUser;

    public int getAgeUser() {
        return ageUser;
    }

    public void setAgeUser(int ageUser) {
        this.ageUser = ageUser;
    }

    public int getAvatarUser() {
        return avatarUser;
    }

    public void setAvatarUser(int avatarUser) {
        this.avatarUser = avatarUser;
    }

    public String getCarModelDriver() {
        return carModelDriver;
    }

    public void setCarModelDriver(String carModelDriver) {
        this.carModelDriver = carModelDriver;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public double getExperienceDriver() {
        return experienceDriver;
    }

    public void setExperienceDriver(double experienceDriver) {
        this.experienceDriver = experienceDriver;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public void setLastNameUser(String lastNameUser) {
        this.lastNameUser = lastNameUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getNumPlateCarDriver() {
        return numPlateCarDriver;
    }

    public void setNumPlateCarDriver(String numPlateCarDriver) {
        this.numPlateCarDriver = numPlateCarDriver;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getPhoneUser() {
        return phoneUser;
    }

    public void setPhoneUser(String phoneUser) {
        this.phoneUser = phoneUser;
    }

    public String getSexUser() {
        return sexUser;
    }

    public void setSexUser(String sexUser) {
        this.sexUser = sexUser;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "ageUser='" + ageUser + '\'' +
                ", avatarUser='" + avatarUser + '\'' +
                ", carModelDriver='" + carModelDriver + '\'' +
                ", emailUser='" + emailUser + '\'' +
                ", experienceDriver='" + experienceDriver + '\'' +
                ", lastNameUser='" + lastNameUser + '\'' +
                ", nameUser='" + nameUser + '\'' +
                ", numPlateCarDriver='" + numPlateCarDriver + '\'' +
                ", passwordUser='" + passwordUser + '\'' +
                ", phoneUser='" + phoneUser + '\'' +
                ", sexUser='" + sexUser + '\'' +
                '}';
    }
}
