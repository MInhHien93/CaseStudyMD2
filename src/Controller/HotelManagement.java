package Controller;

import Entities.Room;
import FileCSV.FileCSVCustomer;
import FileCSV.FileCSVRoom;

import java.util.ArrayList;

import static Controller.CustomerManagement.customers;

public class HotelManagement {
    public static ArrayList<Room> rooms = new ArrayList<>();

    public void checkRoom(int idRoom) {


    }

    public void addCustomerToRoom(String name, Room room) {
        customers = FileCSVCustomer.readCustomersFileCSV();
        rooms = FileCSVRoom.readRoomsFileCSV();



    }
}
