
package JavaProjekt;
public abstract class Sections {
    private static int numOfUnits;
    private int id;
    private String desc;
    private String size; 
    private double price;
    private boolean available;

public Sections(String desc, String size, double price , int id)  {
        this.desc=desc;
        this.size=size;
        this.price=price;
        available=true;
        this.id = id;
}

    public static int getNumOfUnits() {
        return numOfUnits;
    }

    public static void setNumOfUnits(int numOfUnits) {
        Sections.numOfUnits = numOfUnits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

  public abstract String showAmenities();

 public abstract String serviceType();

    @Override
    public String toString() {
        return  "ID : " + id 
                + "\nDesc : " + desc 
                + "\nThe Size is : " + size 
                + "\nThe Price is : " + price 
                + "\nIt is Available : " + available;
    }



}
    

