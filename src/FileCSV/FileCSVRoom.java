package FileCSV;

import Controller.HotelManagement;
import Entities.Customer;
import Entities.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileCSVRoom {
    private static final String COMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String PATH_ROOM = "src/Hotel.csv";
    private static final String FILE_HEADER = "idRoom, typeOfRoom, priceOfRoom, dateOfRent, nameCustomer";

    public static void writeRoomToFileCSV(ArrayList<Customer> customers) throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter(PATH_ROOM);
            fw.append(FILE_HEADER);
            fw.append(NEW_LINE_SEPARATOR);
            for (Room r : HotelManagement.rooms) {
                fw.append(r.getIdRoom()+"");
                fw.append(COMA_DELIMITER);
                fw.append(r.getTypeOfRoom());
                fw.append(COMA_DELIMITER);
                fw.append(r.getPriceOfRoom()+"");
                fw.append(COMA_DELIMITER);
                fw.append(r.getDateOfRent()+"");
                fw.append(COMA_DELIMITER);
                fw.append(r.getNameCustomer());
                fw.append(NEW_LINE_SEPARATOR);
            }
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Lỗi ghi file CSV!");
        } finally {
            try {
                fw.flush();
                fw.close();
            } catch (Exception e) {
                System.out.println("Lỗi khi đóng luồng và đồng bộ!");
            }
        }
    }

    public static ArrayList<Room> readRoomsFileCSV() {
        BufferedReader br = null;
        ArrayList<Room> rooms = new ArrayList<>();
        Path path = Paths.get(PATH_ROOM);
//        if (!Files.exists(path)) {
//            try {
//                Writer writer = new FileWriter(PATH);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
        try {
            br = new BufferedReader(new FileReader(PATH_ROOM ));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("name")) {
                    continue;
                }
                Room room = new Room();
                room.setIdRoom(Integer.parseInt(splitData[0]));
                room.setTypeOfRoom(splitData[1]);
                room.setPriceOfRoom(Long.parseLong(splitData[2]));
                room.setDateOfRent(Integer.parseInt(splitData[3]));
                rooms.add(room);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return rooms;
    }
}
