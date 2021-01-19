package com.company.util;

import com.company.model.ICoordinate;

public interface IDistanceCalcStrategy {
    public double calcDistance(ICoordinate coordinate1,
                               ICoordinate coordinate2);
}
