package FileCSV;

import Entities.Customer;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileCSVCustomer {
    private static final String COMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String PATH_CUSTOMER = "src/customer.csv";
    private static final String FILE_HEADER = "name, dateOfBirth, identity";

    public static void writeCustomerToFileCSV(ArrayList<Customer> customers) throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter(PATH_CUSTOMER);
            fw.append(FILE_HEADER);
            fw.append(NEW_LINE_SEPARATOR);
            for (Customer c : customers) {
                fw.append(c.getName());
                fw.append(COMA_DELIMITER);
                fw.append(c.getDateOfBirth());
                fw.append(COMA_DELIMITER);
                fw.append(c.getIdentity());
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

    public static ArrayList<Customer> readCustomersFileCSV() {
        BufferedReader br = null;
        ArrayList<Customer> customers = new ArrayList<>();
        Path path = Paths.get(PATH_CUSTOMER);
//        if (!Files.exists(path)) {
//            try {
//                Writer writer = new FileWriter(PATH);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
        try {
            br = new BufferedReader(new FileReader(PATH_CUSTOMER));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("name")) {
                    continue;
                }
                Customer customer = new Customer();
                customer.setName(splitData[0]);
                customer.setDateOfBirth(splitData[1]);
                customer.setIdentity(splitData[2]);
                customers.add(customer);
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
        return customers;
    }
}
