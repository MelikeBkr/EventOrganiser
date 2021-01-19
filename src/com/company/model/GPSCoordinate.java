package com.company.model;

public class GPSCoordinate implements ICoordinate
{
    private double latitude;
    private double longitude;

    public GPSCoordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public double getLatitude() {
        return latitude;
    }
    @Override
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    @Override
    public double getLongitude() {
        return longitude;
    }
    @Override
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
