package JavaProjekt;

public class HotelRestaurant implements Reservationable {
    private String name;
    private String cuisine;
    private int price;
    private double rating;

    public HotelRestaurant(String name, String cuisine, int price, double rating) {
        this.name = name;
        this.cuisine = cuisine;
        this.price = price;
        this.rating = rating;
    }

    public HotelRestaurant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public final void Reservation() {
        System.out.println(" Reservation has been confirmed.");
    }

    @Override
    public double calcTotal() {
        double Total = 0;
        if (rating >= 5) {
            Total = (5 * 50);
        } else if (rating >= 4) {
            Total = (4 * 50);
        } else if (rating >= 3) {
            Total = (3 * 50);
        } else {
            Total = 50;
        }
        Total = Total + price;
        Total += Total * Reservationable.TAX;
        return Total;
    }

    @Override
    public String toString() {
        return "HotelRestaurant:" + "\nname=" 
                + name + "\ncuisine="
                + cuisine + "\nprice=" 
                + price + "\nrating="
                + rating ;
    }

}
