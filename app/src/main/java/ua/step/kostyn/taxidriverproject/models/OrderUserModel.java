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
    private double priceUserOrder;
    private String commentUserOrder;

    private DriverModel driverModel;
    private DriverLocationModel driverLocationModel;
    private UserOrderStatusModel userOrderStatusModel;

    public int getIdUserOrder() {
        return idUserOrder;
    }

    public void setIdUserOrder(int idUserOrder) {
        this.idUserOrder = idUserOrder;
    }

    public String getFromUserOrder() {
        return fromUserOrder;
    }

    public void setFromUserOrder(String fromUserOrder) {
        this.fromUserOrder = fromUserOrder;
    }

    public String getToUserOrder() {
        return toUserOrder;
    }

    public void setToUserOrder(String toUserOrder) {
        this.toUserOrder = toUserOrder;
    }

    public Date getWhenUserOrder() {
        return whenUserOrder;
    }

    public void setWhenUserOrder(Date whenUserOrder) {
        this.whenUserOrder = whenUserOrder;
    }

    public double getPriceUserOrder() {
        return priceUserOrder;
    }

    public void setPriceUserOrder(double priceUserOrder) {
        this.priceUserOrder = priceUserOrder;
    }

    public String getCommentUserOrder() {
        return commentUserOrder;
    }

    public void setCommentUserOrder(String commentUserOrder) {
        this.commentUserOrder = commentUserOrder;
    }

    public DriverModel getDriverModel() {
        return driverModel;
    }

    public void setDriverModel(DriverModel driverModel) {
        this.driverModel = driverModel;
    }

    public DriverLocationModel getDriverLocationModel() {
        return driverLocationModel;
    }

    public void setDriverLocationModel(DriverLocationModel driverLocationModel) {
        this.driverLocationModel = driverLocationModel;
    }

    public UserOrderStatusModel getUserOrderStatusModel() {
        return userOrderStatusModel;
    }

    public void setUserOrderStatusModel(UserOrderStatusModel userOrderStatusModel) {
        this.userOrderStatusModel = userOrderStatusModel;
    }
}
