package com.company.util;


import com.company.model.ICoordinate;

public class GreatCircleDistanceCalc implements IDistanceCalcStrategy
{
    private final double CONSTANT_DEGREE = 180;
    private final int EARTH_RADIUS = 6371;

    @Override
    public double calcDistance(ICoordinate coordinate1,
                                      ICoordinate coordinate2)
    {
        double latitudeDistance = convertDegree2Radian(coordinate2.getLatitude()-coordinate1.getLatitude());
        double longtitudeDistance = convertDegree2Radian(coordinate2.getLongitude()-coordinate1.getLongitude());

        double c1Lattitude = convertDegree2Radian(coordinate1.getLatitude());
        double c2Lattitude = convertDegree2Radian(coordinate2.getLatitude());



        double a = Math.pow(Math.sin(latitudeDistance / 2), 2)
                + Math.pow(Math.sin(longtitudeDistance / 2), 2)
                * Math.cos(c1Lattitude) * Math.cos(c2Lattitude);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        System.out.println(c*EARTH_RADIUS);
        return c*EARTH_RADIUS;
    }
    public double convertDegree2Radian(double degree)
    {
        double radian = degree*Math.PI/CONSTANT_DEGREE;
        return radian;
    }
}