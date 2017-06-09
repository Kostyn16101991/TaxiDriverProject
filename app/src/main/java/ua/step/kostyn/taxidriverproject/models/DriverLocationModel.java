package ua.step.kostyn.taxidriverproject.models;

/**
 * Created by konstantin on 26.05.17.
 */

public class DriverLocationModel {
    private int idDriverLocation;
    private double latitudeDriverLocation;
    private double longitudeDriverLocation;

    public int getIdDriverLocation() {
        return idDriverLocation;
    }

    public void setIdDriverLocation(int idDriverLocation) {
        this.idDriverLocation = idDriverLocation;
    }

    public double getLatitudeDriverLocation() {
        return latitudeDriverLocation;
    }

    public void setLatitudeDriverLocation(double latitudeDriverLocation) {
        this.latitudeDriverLocation = latitudeDriverLocation;
    }

    public double getLongitudeDriverLocation() {
        return longitudeDriverLocation;
    }

    public void setLongitudeDriverLocation(double longitudeDriverLocation) {
        this.longitudeDriverLocation = longitudeDriverLocation;
    }
}
