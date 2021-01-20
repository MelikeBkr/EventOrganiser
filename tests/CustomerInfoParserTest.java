import com.company.model.Customer;
import com.company.util.CustomerInfoParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class CustomerInfoParserTest
{
    @Test
    public void testInvalidFilePath() throws IOException
    {
        //GIVEN
        CustomerInfoParser customerInfoParser = new CustomerInfoParser();
        //WHEN
        List<Customer> customerList = customerInfoParser.getCustomers(".\\invalid_path.txt");
        //THEN
        Assert.assertEquals(true,customerList.isEmpty());
    }

    @Test
    public void testParseCustomerInfo() throws IOException
    {
        //GIVEN
        CustomerInfoParser customerInfoParser = new CustomerInfoParser();
        //WHEN
        List<Customer> customerList = customerInfoParser.getCustomers(".\\customer.txt");
        //THEN
        Assert.assertEquals(customerList.size(),32);
    }
}
