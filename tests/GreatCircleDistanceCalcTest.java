import com.company.model.GPSCoordinate;
import com.company.model.ICoordinate;
import com.company.util.GreatCircleDistanceCalc;
import com.company.util.IDistanceCalcStrategy;
import org.junit.Assert;
import org.junit.Test;

public class GreatCircleDistanceCalcTest
{
    private static final double DELTA = 1e-15;
    @Test
    public void testDistanceBetweenTwoPoints()
    {
        //Given
        IDistanceCalcStrategy greatCircleDistCalc = new GreatCircleDistanceCalc();
        ICoordinate gpsCoordinate1 = new GPSCoordinate(40.741895,-73.989308);
        ICoordinate gpsCoordinate2 = new GPSCoordinate(41.68856502510449,2.152849996073396);
        //When
        double distanceInKm = greatCircleDistCalc.calcDistance(gpsCoordinate1,gpsCoordinate2);
        //Then
        Assert.assertEquals((int)(6146.727) , (int)distanceInKm);
    }
}
