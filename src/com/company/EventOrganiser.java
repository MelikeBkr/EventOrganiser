package com.company;
import com.company.model.Customer;
import com.company.model.GPSCoordinate;
import com.company.model.ICoordinate;
import com.company.util.CustomerInfoParser;
import com.company.util.GreatCircleDistanceCalc;
import com.company.util.IDistanceCalcStrategy;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EventOrganiser {
    private static final double DUBLIN_OFFICE_LATITUDE = 53.339428;
    private static final double DUBLIN_OFFICE_LONGITUDE = -6.257664;
    private static final double RANGE = 100;

    public static void main(String[] args) throws IOException, ParseException {
        CustomerInfoParser customerInfoParser = new CustomerInfoParser();
        List<Customer> customerList = customerInfoParser.getCustomers(".\\customer.txt");
        IDistanceCalcStrategy greatCircleDistCalc = new GreatCircleDistanceCalc();
        ICoordinate officeCoordinate = new GPSCoordinate(DUBLIN_OFFICE_LATITUDE,DUBLIN_OFFICE_LONGITUDE);
        CustomerSelector customerSelector = new CustomerSelector();
        List<Customer> invitedCustomers = customerSelector.findInvitees(customerList,officeCoordinate,greatCircleDistCalc, RANGE);

        try {
            FileWriter fileWriter = new FileWriter(".\\output.txt");
            for(Customer customer:invitedCustomers)
            {
                fileWriter.write("name: "+customer.getName());
                fileWriter.write(", ");
                fileWriter.write("user_id: "+customer.getUserId());
                fileWriter.write(System.getProperty( "line.separator" ));
            }
            fileWriter.close();
            System.out.println("Output file successfully generated.");
        }
        catch (IOException e)
        {
            System.out.println("An error occurred while writing to output file.");
            e.printStackTrace();
        }
    }



}
