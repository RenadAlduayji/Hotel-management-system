package JavaProjekt;
public class Reservation implements Reservationable {
    private static int num = 1;
    private final int Reservation_ID ;
    private Customer customer;
    private Sections sections[];
    private Date date;
    private boolean available;
    private String status;
   

    public Reservation(Customer customer, Sections sections[], Date date) {
        this.customer = customer;
        this.sections = sections;
        this.date = date;
        this.available = true;
        this.status = "Cancelled";
        Reservation_ID = num++;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Sections[] getSections() {
        return sections;
    }

    public void setSections(Sections[] sections) {
        this.sections = sections;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getReservation_ID() {
        return Reservation_ID;
    }

    public static double getTAX() {
        return TAX;
    }

    public static int getMAX_RESERVATION() {
        return MAX_RESERVATION;
    }

    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
   
    public final int generateld() {

        int min = 1;
        int max = 1000;
        int id = (int) (Math.random() * ((max - min) + 1)) + min;
        return id;

    }

    @Override
    public void Reservation() {
        setStatus("Confirmed");
        System.out.println("Reservation has been confirmed.");
    }

    public final void cancel() {
        setStatus("Cancelled");
        System.out.println("Reservation has been cancelled.");
    }

    @Override
    public double calcTotal() {
        double total = 0;
        for (Sections ro : sections) {
            total += ro.getPrice();
        }
        total += total * Reservationable.TAX;

        return total;
    }

    public String sections() {

        String s = "";
        for (Sections ser : sections) {
            s += ser + "\n-----------------------------------------------------------------\n";
        }
        return s;
    }

    @Override
    public String toString() {
        return      "Reservation ID is : " + Reservation_ID
                + "\n \nCustomer : " + customer
                + "\n \nThe Sections is : " + sections()
                
                + "\n \nStatus is : " + status
                + "\n \nIt is Available : " + available;
    }

}
