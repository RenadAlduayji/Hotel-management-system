
package JavaProjekt;
  public class Customer {
      private int ID ;
    private String name ;    
    private String email ;
    private String phoneNo ;

    public Customer(int ID, String name, String email, String phoneNo) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }
    public Customer() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return " ID : " + ID 
                + ". Name is : " + name 
                + ". The Email is : " + email 
                + ". The Phone Number is : " + phoneNo; 
}
  }
