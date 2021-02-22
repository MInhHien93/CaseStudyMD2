package Controller;

import Entities.Room;
import FileCSV.FileCSVCustomer;
import FileCSV.FileCSVRoom;

import java.io.IOException;
import java.util.ArrayList;

import static Controller.CustomerManagement.customers;

public class HotelManagement {
    public static ArrayList<Room> rooms = new ArrayList<>();
    public static ArrayList<Integer> listIdRomUsed = new ArrayList<>();

    public void roomUsed() {
        rooms = FileCSVRoom.readRoomsFileCSV();
        for (int i = 0; i < rooms.size(); i++) {
            listIdRomUsed.add(rooms.get(i).getIdRoom());
        }
    }

    public void addCustomerToRoom(Room room) throws IOException {
//        customers = FileCSVCustomer.readCustomersFileCSV();
        rooms = FileCSVRoom.readRoomsFileCSV();
        rooms.add(room);
        FileCSVRoom.writeRoomToFileCSV(rooms);
    }

    public void showAllRoom() {
        rooms = FileCSVRoom.readRoomsFileCSV();
        for (Room r : rooms) {
            System.out.println(r.toString());
        }
    }

    public long checkOut(String name) {
        rooms = FileCSVRoom.readRoomsFileCSV();
        long bill = 0;
        for (Room r : rooms) {
            if (r.getNameCustomer().equals(name)) {
                bill = r.getDateOfRent() * r.getPriceOfRoom();
            }
        }
        return bill;
    }
}
