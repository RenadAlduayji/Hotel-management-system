
package JavaProjekt;
public class Suite extends Sections{
    private int numOfRooms;
    private int maxCustomer;

    public Suite(int numOfRooms, int maxCustomer, String desc, String size, double price, int id) {
        super(desc, size, price, id);
        this.numOfRooms = numOfRooms;
        this.maxCustomer = maxCustomer;
    }

    public Suite() {

        this(0,0,null,null,0.0,0);
    }

   
    @Override
    public   String showAmenities() {
        return "\nSwimming Pool "
        +"\nRestaurant Options "
        +"\nfree wifi ";

    }
     @Override
    public  String serviceType() {
        return "VIP Services and Butler Service";
    }
    public  String spaServicestype() {
        return "Spa services for the suite"
                + "\n1- Nail Manicure"
                + "\n2- Nail Beddler"
                + "\n3- Massages"
                + "\n4- Hydrotherapy"
                + "\n5- Day Spa";
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }
       public void setNumOfRooms(int numOfRooms) {
        this.numOfRooms = numOfRooms;
    }

    public int getmaxCustomer() {
        return maxCustomer;
    }

    public void setmaxCustomer(int maxCustomer) {
        this.maxCustomer = maxCustomer;
    }

     @Override
    public String toString() {
        return  super.toString()
                +"\nThe Number Of Rooms is: " + numOfRooms
                + "\nMax Customer is : " + maxCustomer;

    }




 
}

    

