package View;

import Entities.Customer;
import Entities.Room;
import Controller.Enum;

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
        System.out.println("Type and price of Room:" +
                "\n 1. Standard - 150.000 đồng/ngày" +
                "\n 2. Superior - 200.000 đồng/ngày" +
                "\n 3. Deluxe - 300.000 đồng/ngày" +
                "\n 4. Suite - 500.000 đồng/ngày");
        System.out.println("Enter a choice: ");
        int choice = Integer.parseInt(Program.sc.nextLine());
        switch (choice) {
            case 1:
                room.setTypeOfRoom("Standard");
                room.setPriceOfRoom(Enum.STANDARD);
                break;
            case 2:
                room.setTypeOfRoom("Superior");
                room.setPriceOfRoom(Enum.SUPERIOR);
                break;
            case 3:
                room.setTypeOfRoom("Duluxe");
                room.setPriceOfRoom(Enum.DELUXE);
                break;
            case 4:
                room.setTypeOfRoom("Suite");
                room.setPriceOfRoom(Enum.SUITE);
                break;
            default:
                break;
        }
        System.out.println("Enter date of rent: ");
        int dateOfRent = Integer.parseInt(Program.sc.nextLine());
        room.setDateOfRent(dateOfRent);
        System.out.println("Enter the namne of customer want to add this room: ");
        String name = Program.sc.nextLine();
        room.setNameCustomer(name);
        return room;
    }
}
