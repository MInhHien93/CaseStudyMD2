package Controller;

import Entities.Customer;
import FileCSV.FileCSVCustomer;

import java.io.IOException;
import java.util.ArrayList;

public class CustomerManagement {

    public static ArrayList<Customer> customers = new ArrayList<>();

    public void add(Customer customer) throws IOException {
        customers = FileCSVCustomer.readCustomersFileCSV();
        customers.add(customer);
        FileCSVCustomer.writeCustomerToFileCSV(customers);
    }

    public Customer searchByName(String name) {
        Customer customer = null;
        for (Customer c: customers) {
            if (c.getName().equals(name)) {
               customer = c;
            }
        }
        return customer;
    }

    public void update(String name, Customer customerAfter) throws IOException {
        customers = FileCSVCustomer.readCustomersFileCSV();
        for (Customer c:customers) {
            if (c.getName().equals(name)) {
                c.setName(customerAfter.getName());
                c.setDateOfBirth(customerAfter.getDateOfBirth());
                c.setIdentity(customerAfter.getIdentity());
            }
        }
        FileCSVCustomer.writeCustomerToFileCSV(customers);
    }

    public boolean delete(String name) throws IOException {
        customers = FileCSVCustomer.readCustomersFileCSV();
        boolean isRemove = false;
        for (Customer c:customers) {
            if (c.getName().equals(name)) {
                customers.remove(c);
                isRemove = true;
            } else isRemove =false;
        }
        FileCSVCustomer.writeCustomerToFileCSV(customers);
        return isRemove;
    }

    public void showAll() {
        customers = FileCSVCustomer.readCustomersFileCSV();
        for (Customer c: customers) {
            System.out.println(c.toString());
        }
    }
}
