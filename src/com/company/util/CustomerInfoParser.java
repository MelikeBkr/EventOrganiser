package com.company.util;
import com.company.model.Customer;
import com.company.model.GPSCoordinate;
import com.company.model.ICoordinate;
import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class CustomerInfoParser
{
    public final String NAME = "name";
    public final String ID = "user_id";
    public final String LATITUDE = "latitude";
    public final String LONGITUDE = "longitude";
    private final static Logger LOGGER = Logger.getLogger(CustomerInfoParser.class.getName());

    public List<Customer> getCustomers(String filePath) throws IOException
    {
        List<JSONObject> customersJsonObjList = new ArrayList<>();
        List<Customer> customerList = new ArrayList<>();
        LOGGER.info("File reading started");
        try
        {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            while ((str = br.readLine()) != null) {
                customersJsonObjList.add(new JSONObject(str));
            }
            for (JSONObject jsonObject : customersJsonObjList) {
                Customer customer = new Customer();

                customer.setName(jsonObject.get(NAME).toString());
                customer.setUserId((int) jsonObject.get(ID));
                double latitude = Double.parseDouble(jsonObject.get(LATITUDE).toString());
                double longitude = Double.parseDouble(jsonObject.get(LONGITUDE).toString());
                ICoordinate coordinate = new GPSCoordinate(latitude, longitude);
                customer.setCoordinate(coordinate);
                customerList.add(customer);
            }
        }
        catch (NullPointerException ex)
        {
            LOGGER.warning(ex.getMessage());
        }
        catch (FileNotFoundException ex)
        {
            LOGGER.warning(ex.getMessage());
        }
    return customerList;
    }
}
