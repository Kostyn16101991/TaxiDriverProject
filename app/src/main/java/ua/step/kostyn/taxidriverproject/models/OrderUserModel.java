package ua.step.kostyn.taxidriverproject.models;

import java.util.Date;

/**
 * Created by konstantin on 24.05.17.
 */

public class OrderUserModel {
   private int idUserOrder;
    private String fromUserOrder;
    private String toUserOrder;
    private Date whenUserOrder;
    private String comentUserOrder;
    private double priceUserOrder;
    private  DriverModel driverModel;

    private UserLocationModel userLocationModel;
    private DriverLocationModel driverLocationModel;
}
