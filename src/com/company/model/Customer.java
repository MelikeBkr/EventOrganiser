package com.company.model;

public class Customer
{
    private int userId;
    private String name;
    private ICoordinate coordinate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCoordinate(ICoordinate coordinate)
    {
        this.coordinate = coordinate;
    }
    public ICoordinate getCoordinate()
    {
        return coordinate;
    }
}
