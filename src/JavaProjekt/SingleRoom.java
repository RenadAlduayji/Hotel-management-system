package JavaProjekt;
public class SingleRoom extends Sections {

    private boolean hasDesk;

    public SingleRoom(boolean hasDesk, String desc, String size, double price, int id) {
        super(desc, size, price, id);
        this.hasDesk = hasDesk;
    }

    public boolean isHasDesk() {
        return hasDesk;
    }

    public void setHasDesk(boolean hasDesk) {
        this.hasDesk = hasDesk;
    }

    @Override
    public String showAmenities() {
        return "TV"
                + "Wi-Fi";
    }

    @Override
    public String serviceType() {
        return "Laundry and Dry Cleaning";
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nhasDesk : " + hasDesk;
    }

}
