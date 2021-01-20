import com.company.CustomerSelector;
import com.company.model.Customer;
import com.company.model.GPSCoordinate;
import com.company.model.ICoordinate;
import com.company.util.GreatCircleDistanceCalc;
import com.company.util.IDistanceCalcStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerSelectorTest
{
    private static final double START_POINT_LATITUDE = 41.0252857;
    private static final double START_POINT_LONGITUDE = 28.9727922;
    @Test
    public void testFindingNumberOfCustomersWithinGivenRange()
    {
        //Given
        List<Customer> customerList = new ArrayList<>();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        Customer customer4 = new Customer();
        Customer customer5 = new Customer();
        ICoordinate coordinate1 = new GPSCoordinate(41.02299504426326,28.977348602564042);
        ICoordinate coordinate2 = new GPSCoordinate(39.89487393382823,32.85539615076944);
        ICoordinate coordinate3 = new GPSCoordinate(38.4369810476291,27.13529574793741);
        ICoordinate coordinate4 = new GPSCoordinate(41.028194096940716,28.96782162009712);
        ICoordinate coordinate5 = new GPSCoordinate(41.02746026324341,29.068660169066597);
        ICoordinate startPointCoordinate = new GPSCoordinate(START_POINT_LATITUDE,START_POINT_LONGITUDE);
        IDistanceCalcStrategy distanceCalcStrategy = new GreatCircleDistanceCalc();
        double range = 30;
        customer1.setCoordinate(coordinate1);
        customer2.setCoordinate(coordinate2);
        customer3.setCoordinate(coordinate3);
        customer4.setCoordinate(coordinate4);
        customer5.setCoordinate(coordinate5);
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
        customerList.add(customer5);
        CustomerSelector customerSelector = new CustomerSelector();

        //WHEN
        List<Customer> invitees = customerSelector.findInvitees(customerList,startPointCoordinate,distanceCalcStrategy,range);

        //THEN
        Assert.assertEquals(3,invitees.size());
    }
    @Test
    public void testGivenCustomerIsOnTheInviteeList()
    {
        //Given
        List<Customer> customerList = new ArrayList<>();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        Customer customer4 = new Customer();
        ICoordinate coordinate1 = new GPSCoordinate(41.02299504426326,28.977348602564042);
        ICoordinate coordinate2 = new GPSCoordinate(39.89487393382823,32.85539615076944);
        ICoordinate coordinate3 = new GPSCoordinate(38.4369810476291,27.13529574793741);
        ICoordinate coordinate4 = new GPSCoordinate(45.78466074762948,4.763584464015214);
        ICoordinate startPointCoordinate = new GPSCoordinate(START_POINT_LATITUDE,START_POINT_LONGITUDE);
        IDistanceCalcStrategy distanceCalcStrategy = new GreatCircleDistanceCalc();
        double range = 500;
        customer1.setCoordinate(coordinate1);
        customer2.setCoordinate(coordinate2);
        customer3.setCoordinate(coordinate3);
        customer4.setCoordinate(coordinate4);
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
        CustomerSelector customerSelector = new CustomerSelector();

        //WHEN
        List<Customer> invitees = customerSelector.findInvitees(customerList,startPointCoordinate,distanceCalcStrategy,range);

        //THEN
        Assert.assertEquals(true,invitees.contains(customer2));
    }

    @Test
    public void testCustomerListIsEmpty()
    {
        //GIVEN
        List<Customer> customerList = new ArrayList<>();
        IDistanceCalcStrategy distanceCalcStrategy = new GreatCircleDistanceCalc();
        double range = 50;
        CustomerSelector customerSelector = new CustomerSelector();
        ICoordinate startPointCoordinate = new GPSCoordinate(START_POINT_LATITUDE,START_POINT_LONGITUDE);

        //WHEN
        List<Customer> inviteeList = customerSelector.findInvitees(customerList,startPointCoordinate,distanceCalcStrategy,range);

        //THEN
        Assert.assertEquals(true, inviteeList.isEmpty());
    }
}
