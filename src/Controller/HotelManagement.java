package Controller;

import Entities.Room;
import FileCSV.FileCSVCustomer;
import FileCSV.FileCSVRoom;

import java.io.IOException;
import java.util.ArrayList;

import static Controller.CustomerManagement.customers;

public class HotelManagement {
    public static ArrayList<Room> rooms = new ArrayList<>();

    public void checkRoom(int idRoom) {


    }

    public void addCustomerToRoom(Room room) throws IOException {
        customers = FileCSVCustomer.readCustomersFileCSV();
        rooms = FileCSVRoom.readRoomsFileCSV();
        rooms.add(room);
        FileCSVRoom.writeRoomToFileCSV(rooms);



    }
}
