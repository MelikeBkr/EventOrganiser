package com.company.util;
import com.company.model.Customer;
import com.company.model.GPSCoordinate;
import com.company.model.ICoordinate;
import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerInfoParser
{
    public final String NAME = "name";
    public final String ID = "user_id";
    public final String LATITUDE = "latitude";
    public final String LONGITUDE = "longitude";

    public List<Customer> getCustomers(String filePath) throws IOException
    {
        List<JSONObject> customersJsonObjList = new ArrayList<>();
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;
        while ((str = br.readLine()) != null)
        {
            customersJsonObjList.add(new JSONObject(str));
        }
        List<Customer> customerList = new ArrayList<>();
        for(JSONObject jsonObject: customersJsonObjList)
        {
            Customer customer = new Customer();
            customer.setName(jsonObject.get(NAME).toString());
            customer.setUserId((int)jsonObject.get(ID));
            Double latitude = Double.parseDouble(jsonObject.get(LATITUDE).toString());
            Double longitude = Double.parseDouble(jsonObject.get(LONGITUDE).toString());
            ICoordinate coordinate = new GPSCoordinate(latitude,longitude);
            customer.setCoordinate(coordinate);
            customerList.add(customer);
        }
    return customerList;
    }
}
