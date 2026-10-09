
package JavaProjekt;
public class DeluxeRoom extends Sections{
   private String bedType;

    public DeluxeRoom(String bedType, String desc, String size, double price, int id) {
        super(desc, size, price, id);
        this.bedType = bedType;
    }

  

    public DeluxeRoom() {
     this(null,null,null,0.0,0);   
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    @Override
    public String showAmenities() {
      return "Special Requests"
              + "\nWake-up Calls";
    }

   @Override
    public String serviceType() {
        return "Personalized Services";
    }

    @Override
    public String toString() {
        return   super.toString()+
                "\nbedType is : " + bedType;


}
    
}

     

