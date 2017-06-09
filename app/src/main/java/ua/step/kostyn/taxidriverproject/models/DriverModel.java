package ua.step.kostyn.taxidriverproject.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by konstantin on 24.05.17.
 */

public class DriverModel {
    private int idDriver;
    private int avatarDriver;
    private String nameDriver;
    private String lastNameDriver;
    private boolean sexDriver;
    private int ageDriver;
    private int phoneDriver;
    private String emailDriver;
    private String passwordDriver;
    private double experienceDriver;
    private String carModelDriver;
    private String numPlateCarDriver;

    private List<OrderUserModel> orderUserModelList = new ArrayList<>();

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public int getAvatarDriver() {
        return avatarDriver;
    }

    public void setAvatarDriver(int avatarDriver) {
        this.avatarDriver = avatarDriver;
    }

    public String getNameDriver() {
        return nameDriver;
    }

    public void setNameDriver(String nameDriver) {
        this.nameDriver = nameDriver;
    }

    public String getLastNameDriver() {
        return lastNameDriver;
    }

    public void setLastNameDriver(String lastNameDriver) {
        this.lastNameDriver = lastNameDriver;
    }

    public boolean isSexDriver() {
        return sexDriver;
    }

    public void setSexDriver(boolean sexDriver) {
        this.sexDriver = sexDriver;
    }

    public int getAgeDriver() {
        return ageDriver;
    }

    public void setAgeDriver(int ageDriver) {
        this.ageDriver = ageDriver;
    }

    public int getPhoneDriver() {
        return phoneDriver;
    }

    public void setPhoneDriver(int phoneDriver) {
        this.phoneDriver = phoneDriver;
    }

    public String getEmailDriver() {
        return emailDriver;
    }

    public void setEmailDriver(String emailDriver) {
        this.emailDriver = emailDriver;
    }

    public String getPasswordDriver() {
        return passwordDriver;
    }

    public void setPasswordDriver(String passwordDriver) {
        this.passwordDriver = passwordDriver;
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
