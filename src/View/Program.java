package View;

import Controller.CustomerManagement;
import Controller.HotelManagement;
import Entities.Customer;
import Entities.Room;

import java.io.IOException;
import java.util.Scanner;

import static Controller.CustomerManagement.customers;
import static Controller.HotelManagement.rooms;


public class Program {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        CustomerManagement cm = new CustomerManagement();
        HotelManagement hotel = new HotelManagement();

        StartMenu:
        do {
            System.out.println("----Hotel Management----" +
                    "\n --------Menu----------" +
                    "\n 1.Customer Management" +
                    "\n 2.Room Management" +
                    "\n ----------------------" +
                    "\n Enter a choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {
                do {
                    System.out.println("---Customer Management---" +
                            "\n --------Menu----------" +
                            "\n 1:Add" +
                            "\n 2:Search" +
                            "\n 3:Update" +
                            "\n 4:Delete" +
                            "\n 5:ShowAll" +
                            "\n ----------------------" +
                            "\n Enter a choice: ");
                    int choice2 = Integer.parseInt(sc.nextLine());
                    switch (choice2) {
                        case 1:
                            Customer customer = Menu.getCustomerInfo();
                            cm.add(customer);
                            for (Customer c : customers) {
                                System.out.println(c.toString());
                            }
                            break;
                        case 2:
                            System.out.println("Enter your name to search:");
                            String nameFound = sc.nextLine();
                            cm.searchByName(nameFound);
                            Customer customerFound = cm.searchByName(nameFound);
                            System.out.println(customerFound.toString());
                            break;
                        case 3:
                            System.out.println("Enter your name to change: ");
                            String nameChanged = sc.nextLine();
                            System.out.println("Enter the information to change: ");
                            Customer changedInfoCus = Menu.getCustomerInfo();
                            cm.update(nameChanged, changedInfoCus);
                            for (Customer c : customers) {
                                System.out.println(c.toString());
                            }
                            break;
                        case 4:
                            System.out.println("Enter your name to delete: ");
                            String nameDeleted = sc.nextLine();
                            cm.delete(nameDeleted);
                            break;
                        case 5:
                            cm.showAll();
                            break;
                        default:
                            continue StartMenu;
                    }
                } while (true);

            } else {
                System.out.println("---Room Management---" +
                        "--------Menu----------" +
                        "\n 1:Check in" +
                        "\n 2:Check room" +
                        "\n 3:Check out" +
                        "\n ----------------------" +
                        "\n Enter a choice: ");
                int choice3 = Integer.parseInt(sc.nextLine());
                switch (choice3) {
                    case 1:
                        Room room = Menu.getRoomInfo();
                        System.out.println("Enter the namne of customer want to add this room: ");
                        String name = sc.nextLine();
                        hotel.addCustomerToRoom(name, room);
                        for (Room r : rooms) {
                            System.out.println(r.toString());
                        }
                        break;
                    case 2:
//                        hotel.showAll();
                        break;
                    case 3:
                        break;
                    default:
                        continue StartMenu;
                }
            }
        } while (true);
    }
}
