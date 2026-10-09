
package JavaProjekt;

public class Date {
private int Day;
private int Month;
private int Year;

    public Date(int Day, int Month, int Year) {
        this.Day = Day;
        this.Month = Month;
        this.Year = Year;
    }

    public Date() {
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int Day) {
        this.Day = Day;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int Month) {
        this.Month = Month;
    }

    public int getYear() {
        return Year;
    }
    
    public void setYear(int Year) {
        this.Year = Year;
    }
   public void Reservation_Date(){ 
     System.out.println(getDay()+"/"+getMonth()+"/"+getYear()); 
   }
}

     

