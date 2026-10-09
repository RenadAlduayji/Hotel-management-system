package JavaProjekt;

import java.util.*;
import java.io.File;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelMain extends Application {

    static Reservation reservation = null;

    static ArrayList<Sections> list = new ArrayList<>();
    static ArrayList<Reservation> ReservationList = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    @Override
    public void start(Stage primaryStage) {
        // about Group and Scene
        Group root = new Group();
        Scene scenen = new Scene(root, 800, 600, Color.LIGHTBLUE);
        
        //about Label
        Label lab = new Label("**** IT HOTEL SYSTEM **** ");
        lab.setLayoutX(350);
        lab.setLayoutY(50);
        
        TextArea textArea = new TextArea(reservation.toString());                                   
        textArea.setLayoutX(100);
        textArea.setLayoutY(80);
        textArea.setPrefWidth(500);
        textArea.setPrefHeight(300);
        textArea.setEditable(false);
        // add to Group
        root.getChildren().add(lab);
        root.getChildren().add(textArea);
        // show GUI
        primaryStage.setScene(scenen);
        primaryStage.setTitle("HOTEL SYSTEM");
        primaryStage.show();

    }

    public static void main(String[] args) {
        int choice = 0;
        fillList(list);
        System.out.println("\u001B[45m"+"*** WELCOME TO IT HOTEI MANAGEMENT SYSTEM ***"+"\u001B[45m");
        do {
            try {
                menu();
                choice = in.nextInt();
                switch (choice) {

                    case 1://Add Sections
                        add();
                        break;

                    case 2://Remove Sections
                        remove();
                        break;

                    case 3://Display Sections
                        for (Sections sections : list) {
                            System.out.println(sections);
                            System.out.printf("Reservation Price Per Day: %.2f SAR.\n", sections.getPrice());

                            //polymorphic methods(abstract and overriden)                       
                            System.out.println("Service type: " + sections.serviceType());
                            System.out.println("Amenities:");
                            sections.showAmenities();
                            //downcasting to call a specific methods
                            if (sections instanceof Suite) {
                                ((Suite) sections).spaServicestype();
                            }
                            System.out.println("***************************************************");
                        }
                        System.out.println("Total Sections: " + Sections.getNumOfUnits());//calling static method
                        break;

                    case 4://New Reservation
                        System.out.print("How many Sections you want to Reservation ?(1..3): ");
                        int num = in.nextInt();
                        if (num < 1 || num > Reservationable.MAX_RESERVATION) {
                            System.out.println("Invalid Reservation number.");
                            continue;
                        }
                        for (Sections sections : list) {
                            System.out.println(sections + "\n");
                        }
                        Sections[] SectionsReservation = new Sections[num];
                        System.out.println("Enter " + num + " sections ids:");
                        int count = 0;
                        while (count < num) {
                            System.out.printf("Enter sections #%d id: ", (count + 1));
                            int SectionsId = in.nextInt();

                            boolean isFound = false;
                            for (Sections ele : list) {
                                if (ele.getId() == SectionsId) {
                                    if (ele.isAvailable()) {
                                        SectionsReservation[count] = ele;
                                        isFound = true;
                                        count++;
                                        break;
                                    } else {
                                        System.out.println("Sorry We dont have this available...");
                                    }
                                }
                            }
                            if (!isFound) {
                                System.out.println("Invalid Section id! ");
                            }
                        }
                        System.out.print("Enter Customer id: ");
                        int id = in.nextInt();
                        in.nextLine();
                        System.out.print("Enter Customer name: ");
                        String name = in.nextLine();
                        System.out.print("Enter Customer email: ");
                        String email = in.nextLine();
                        System.out.print("Enter Customer phoneNo: ");
                        String phoneNo = in.nextLine();
                        Customer customer = new Customer(id, name, email, phoneNo);
                     System.out.print("Enter the Reservation Date: " 
                                  +"\nday : " );
                        int day = in.nextInt();
                        System.out.print("month : ");
                        int month = in.nextInt();
                        System.out.print("year : ");
                        int year = in.nextInt();
                        Date date = new Date (day,month,year);
                        reservation = new Reservation(customer, SectionsReservation, date);
                        System.out.print("Confirm Reservation ? (Y/N): ");
                        char answer = in.next().charAt(0);
                        if (answer == 'y' || answer == 'Y') {

                            for (Sections section : SectionsReservation) {
                                section.setAvailable(true);
                            }
                            reservation.Reservation();
                            ReservationList.add(reservation);
                            System.out.println(reservation);
                            System.out.println("The Reservation Date is: ");
                            date.Reservation_Date();
                        } else {
                            System.out.println("Your Reservation has been cancelled!");
                        }

                        break;

                    case 5://Show Reservation
                        System.out.print("Enter reserration id: ");
                        int reservationId = in.nextInt();
                        boolean found = false;
                        for (Reservation ele : ReservationList) {
                            if (ele.getReservation_ID() == reservationId) {
                                System.out.println(ele);
                                System.out.println("The totla is with Vat: " + ele.calcTotal());
                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println("Reservation with id " + reservationId + " is not found.");
                        }

                        break;
                    case 6:  //Cancel Reservation
                        System.out.print("Enter Reservation id: ");
                        reservationId = in.nextInt();
                        found = false;
                        for (Reservation ele : ReservationList) {
                            if (ele.getReservation_ID() == reservationId) {

                                ele.cancel();
                                System.out.println(ele);
                                found = true;
                            }
                        }
                        if (found == false) {
                            System.out.println("Reservation with id " + reservationId + " is not Canceled.");
                        }
                        break;

                    case 7://HotelRestaurant Reservation

                        ArrayList<HotelRestaurant> hotelRestaurant = new ArrayList<>();
                        hotelRestaurant.add(new HotelRestaurant("Pizza", "Italian", 90, 4.5));
                        hotelRestaurant.add(new HotelRestaurant("Masala", "Indian", 65, 3.5));
                        hotelRestaurant.add(new HotelRestaurant("Croissants", "French", 30, 2.8));

                        //show the list
                        for (int i = 0; i < hotelRestaurant.size(); i++) {
                            System.out.println((i + 1) + ": " + hotelRestaurant.get(i));
                            System.out.println("------------------------");
                        }
                        System.out.print("Enter your order from Hotel Restaurant: ");
                        int index = in.nextInt();
                        if (index - 1 < 0 || index - 1 >= hotelRestaurant.size()) {
                            System.out.println("invalid order");
                            continue;
                        }
                        HotelRestaurant hotelRestaurant2 = hotelRestaurant.get(index - 1);
                        System.out.printf("Your Reservation total is: %.2f SAR\n", hotelRestaurant2.calcTotal());
                        System.out.println("Thanks for the Reservation!");
                        break;
                    case 8://GUI
                        //GUI.main(null); //calling static method
                         if (reservation == null) {
                            System.out.println("you should have reservation to show in GUI");
                        } else {
                             launch(args);
                        }
                        break;
                    case 9: //Read from text file
                        ReadText rt = new ReadText();
                        rt.openTextFile("Sections.txt");
                        System.out.println(rt.readFromFile());
                        rt.closeFile();
                        break;

                    case 10://Save Write to text file
                        WriteText t = new WriteText();
                        t.openTextFile("Sections.txt");
                        if (reservation == null) {
                            System.out.println(" you should have reservation for save in file ");
                        } else {
                            t.writeToFile(reservation);
                        }
                        t.closeFile();
                        break;

                    case 11:
                        System.out.println("\u001B[45m"+"***** Thank you for using our system *****"
                                + "\nWe wish you a happy day <3."+ "\u001B[45m");
                        break;
                    default:
                        System.out.println("Invalid option! ");
                }

            } catch (InputMismatchException ex) {
                System.out.println("Invalid input");
                in.nextLine();
            } catch (NullPointerException ex) {
                System.out.println(ex);
            } catch (ClassCastException ex) {
                System.out.println(ex);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println(ex);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } while (choice != 11);
    }

    public static void menu() {

        System.out.print("""
                         
                         1. Add Sections.
                         2. Remove Sections.
                         3. Display Sections.
                         4. New Reservation.
                         5. Show Reservation.
                         6. Cancel Reservation.
                         7. Restaurant Reservation
                         8. GUI.
                         9. Read From File.
                         10.Save Sections.
                         11.Exit.
                         >> """);

    }

    public static void add() {
        System.out.print("""
                         1. Suite
                         2. Single room
                         3. Deluxe room
                         choose  the Sections you want >> """);
        int type = in.nextInt();

        if (type < 1 || type > 3) {
            System.out.println("Invalid choice.");
        } else {

            Sections room;
            System.out.print("How many beds do you want : ");
            int numOfBeds = in.nextInt();
            if (type == 1) {

                System.out.print("How many rooms do you want : ");
                int numOfRooms = in.nextInt();
                System.out.print("How many members : ");
                int maxCustomer = in.nextInt();
                System.out.print("Please Enter Your id : ");
                int id = in.nextInt();
                System.out.println("\u001B[45m"+"***** Done! Thank you, I wish you a happy stay *****"+"\u001B[45m");
                room = new Suite(numOfRooms, maxCustomer, "City view, Air conditioning , Flat-screen TV \n Soundproof, Coffee machine, Free WiFi", "90m^2", 3500, id);
                list.add(room);

            } else if (type == 2) {

                System.out.print("Im soory there is no Description. Do want it?");
                boolean hasDesk = in.nextBoolean();
                if (hasDesk == true) {
                    System.out.print("Please Enter Your id : ");
                    int id = in.nextInt();
                    System.out.println("\u001B[45m"+"***** Done! Thank you, I wish you a happy stay *****"+"\u001B[45m");
                    room = new SingleRoom(true, "Air conditioning , Free WiFi , TV ", "60m^2", 1500, id);
                    list.add(room);
                } else {
                    System.out.println("Thank you!");

                }

            } else {
                System.out.print("Please Enter Your id : ");
                int id = in.nextInt();
                room = new DeluxeRoom("2 Queen Bed", " Balcony, Air conditioning, Private Bathroom, Flat-screen TV,\n Soundproof, Coffee machine, Free WiFi", "75m^2", 2500, id);
                list.add(room);
                System.out.println("sections has been added to the list.");
            }
        }
    }

    public static void remove() {

        System.out.print("Enter section id to remove: ");
        int section_ID = in.nextInt();
        boolean removed = false;
        for (int i = 0; i < list.size(); i++) {
            Sections e = list.get(i);
            if (e.getId() == section_ID) {
                list.remove(i);
                removed = true;
                break;
            }
        }//end loop
        if (removed) {
            System.out.println("Section with id " + section_ID + " has been removed.");
        } else {
            System.out.println("No section with id " + section_ID + " is found.");
        } //end else
    }

    public static void fillList(ArrayList<Sections> list) {

        list.add(new Suite(3, 8, "City view, Air conditioning, Flat-screen TV,\n Soundproof, Coffee machine, Free WiFi", "90m^2", 3500, 101));

        list.add(new Suite(5, 12, "City view, Air conditioning, Flat-screen TV,\n Soundproof, Coffee machine, Free WiFi", "100m^2", 3500, 102));

        list.add(new SingleRoom(true, "Air conditioning , Free WiFi , TV ", "60m^2", 1500, 103));

        list.add(new DeluxeRoom("2 Queen Bed", "Balcony, Air conditioning, Private Bathroom, Flat-screen TV,\n Soundproof, Coffee machine, Free WiFi", "75m^2", 2500, 104));

    }
}
