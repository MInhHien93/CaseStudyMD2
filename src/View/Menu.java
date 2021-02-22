package View;

import Entities.Customer;
import Entities.Room;
import Controller.Enum;

import static Controller.CustomerManagement.customers;

public class Menu {

    public static Customer getCustomerInfo() {
        Customer customer = new Customer();
        System.out.println("Enter customer's name: ");
        String name = Program.sc.nextLine();
        customer.setName(name);
        System.out.println("Enter customer's identity: ");
        String identity = Program.sc.nextLine();
        customer.setIdentity(identity);
        System.out.println("Enter customer's date of birth: ");
        String dateOfBirth = Program.sc.nextLine();
        customer.setDateOfBirth(dateOfBirth);
        return customer;
    }

    public static Room getRoomInfo() {
        Room room = new Room();
        System.out.println("Enter id room: ");
        int idRoom = Integer.parseInt(Program.sc.nextLine());
        room.setIdRoom(idRoom);
        System.out.println("Types of rooms in Hotel: " + "Standard" + "/Superior" + "/Deluxe" + "/Suite");
        System.out.println("Enter type of room: ");
        String typeOfRoom = Program.sc.nextLine();
        room.setTypeOfRoom(typeOfRoom);
        System.out.println("Type of Room:" +
                "\n 1. Standard" +
                "\n 2. Superior" +
                "\n 3. Deluxe" +
                "\n 4. Suite");
        System.out.println("Enter a choice: ");
        int choice = Integer.parseInt(Program.sc.nextLine());
        switch (choice) {
            case 1:
                room.setPriceOfRoom(Enum.STANDARD);
                break;
            case 2:
                room.setPriceOfRoom(Enum.SUPERIOR);
                break;
            case 3:
                room.setPriceOfRoom(Enum.DELUXE);
                break;
            case 4:
                room.setPriceOfRoom(Enum.SUITE);
                break;
            default:
                break;
        }
        System.out.println("Enter date of rent: ");
        int dateOfRent = Integer.parseInt(Program.sc.nextLine());
        room.setDateOfRent(dateOfRent);
        return room;
    }
}
