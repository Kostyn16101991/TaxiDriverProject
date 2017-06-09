package ua.step.kostyn.taxidriverproject.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by konstantin on 24.05.17.
 */

public class DriverModel {
    private int idUser;
    private int avatarUser;
    private String nameUser;
    private String lastNameUser;
    private boolean sexUser;
    private int ageUser;
    private String phoneUser;
    private String emailUser;
    private String passwordUser;
    private double experienceDriver;
    private String carModelDriver;
    private String numPlateCarDriver;

    private List<OrderUserModel> orderUserModelList = new ArrayList<>();

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getAvatarUser() {
        return avatarUser;
    }

    public void setAvatarUser(int avatarUser) {
        this.avatarUser = avatarUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public void setLastNameUser(String lastNameUser) {
        this.lastNameUser = lastNameUser;
    }

    public boolean isSexUser() {
        return sexUser;
    }

    public void setSexUser(boolean sexUser) {
        this.sexUser = sexUser;
    }

    public int getAgeUser() {
        return ageUser;
    }

    public void setAgeUser(int ageUser) {
        this.ageUser = ageUser;
    }

    public String getPhoneUser() {
        return phoneUser;
    }

    public void setPhoneUser(String phoneUser) {
        this.phoneUser = phoneUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public double getExperienceDriver() {
        return experienceDriver;
    }

    public void setExperienceDriver(double experienceDriver) {
        this.experienceDriver = experienceDriver;
    }

    public String getCarModelDriver() {
        return carModelDriver;
    }

    public void setCarModelDriver(String carModelDriver) {
        this.carModelDriver = carModelDriver;
    }

    public String getNumPlateCarDriver() {
        return numPlateCarDriver;
    }

    public void setNumPlateCarDriver(String numPlateCarDriver) {
        this.numPlateCarDriver = numPlateCarDriver;
    }

    public List<OrderUserModel> getOrderUserModelList() {
        return orderUserModelList;
    }

    public void setOrderUserModelList(List<OrderUserModel> orderUserModelList) {
        this.orderUserModelList = orderUserModelList;
    }

    @Override
    public String toString() {
        return "DriverModel{" +
                "idUser=" + idUser +
                ", avatarUser=" + avatarUser +
                ", nameUser='" + nameUser + '\'' +
                ", lastNameUser='" + lastNameUser + '\'' +
                ", sexUser=" + sexUser +
                ", ageUser=" + ageUser +
                ", phoneUser=" + phoneUser +
                ", emailUser='" + emailUser + '\'' +
                ", passwordUser='" + passwordUser + '\'' +
                ", experienceDriver=" + experienceDriver +
                ", carModelDriver='" + carModelDriver + '\'' +
                ", numPlateCarDriver='" + numPlateCarDriver + '\'' +
                ", orderUserModelList=" + orderUserModelList +
                '}';
    }

    public static class Driver{
        private static DriverModel driverModel = new DriverModel();


        public Driver() {
        }


        public static void setDriverModel(DriverModel driverModel) {
            Driver.driverModel = driverModel;
        }

        public static DriverModel getDriverModel() {
            return driverModel;
        }
    }
}
