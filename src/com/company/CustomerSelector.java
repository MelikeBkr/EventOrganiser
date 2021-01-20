package com.company;

import com.company.model.Customer;
import com.company.model.ICoordinate;
import com.company.util.IDistanceCalcStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomerSelector
{
    private IDistanceCalcStrategy distanceCalcStrategy;

    public IDistanceCalcStrategy getDistanceCalcStrategy() {
        return distanceCalcStrategy;
    }

    public void setDistanceCalcStrategy(IDistanceCalcStrategy distanceCalcStrategy) {
        this.distanceCalcStrategy = distanceCalcStrategy;
    }
    public List<Customer> findInvitees(List<Customer> customerList, ICoordinate coordinate, IDistanceCalcStrategy distanceCalcStrategy, double range)
    {
        List<Customer> inviteeList = new ArrayList<>();
        if(customerList.isEmpty())
        {
            return inviteeList;
        }

        this.distanceCalcStrategy = distanceCalcStrategy;
        for(Customer customer:customerList)
        {
            double distance = distanceCalcStrategy.calcDistance(coordinate, customer.getCoordinate());
            if(distance<=range)
            {
                inviteeList.add(customer);
            }
        }
        inviteeList.sort(Comparator.comparingInt(Customer::getUserId));
        return inviteeList;
    }

}
