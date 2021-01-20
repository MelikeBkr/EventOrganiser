# Event Organiser
- Reading customer records from a text file (customers.txt) -- one customer per line, JSON lines formatted.
- Based on the given GPS coordinates, find all customers within the given range.
- Distance calculation must be performed by taking Great-circle distance into consideration.


### Classes & Package Structure

##### Model
###### Customer:
Contains id,name and coordinates info of the customers that are listed in customer.txt
###### GPSCoordinate: 
Implements ICoordinate inteface. ICoordinate interface was created in case giving the coordinate values in different ways in the future.

##### Util
###### CustomerInfoParser: 
Pars the relevant file on the given path and accesses the details of the customer information. It stores each customer information as an item in the list of Customer type.

Complexity of getCustomers method: O(N)
*N corresponds to number of JSON formatted lines = number of customers.

###### GreatCircleDistanceCalc:
Implements IDistanceCalcStrategy. IDistanceCalcStrategy interface was created in case the distance calculation strategy changes in the future. It uses the formula explained in; https://en.wikipedia.org/wiki/Great-circle_distance#Formulae in order to find shortest-distance on a sphere.

###### CustomerSelector:
Makes a list of customers to be invited to the event.It performs this by using the list of all customers, constant office coordinates, specified distance calculation strategy and specified range data.
It reaches the distance value by calling the calcDistance method through the IDistanceCalc interface and compares this value with the specified range.
If it is within the specified range, it adds it to the inviteeList.

Complexity of findInvitees() method: O(N)
*N corresponds to size of the customer list

###### EventOrganiser:
It is the main class that calls the methods that perform the essential operations. It was created to present the invitee list as output.

### Instructions:
* Open Solution in a Java IDE (This project is implemented in IntelliJ IDEA)
* In order to parse data from customers.txt and convert into a json object JSON library must be imported (org.json)
(In IntelliJ: Project Structure>Libraries>+>From Maven> Search for org.json and import it)
* Run 'Main' (which is in EventOrganiser class)
* output.txt will be generated in project root directory after the program is running. 
* junit-4.13 jar must be imported for unit tests. 
(In IntelliJ: Project Structure>Libraries>+>From Maven> Search for junit, select version 4.13 and import it)
* right click "tests" directory and select "Run All Test Cases"
