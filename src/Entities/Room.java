package Entities;

import java.util.List;

public class Room {
    private int idRoom;
    private String typeOfRoom;
    private long priceOfRoom;
    private int dateOfRent;
    private String nameCustomer;

    public Room() {
    }

    public Room(int idRoom, String typeOfRoom, long priceOfRoom, int dateOfRent, String nameCustomer) {
        this.idRoom = idRoom;
        this.typeOfRoom = typeOfRoom;
        this.priceOfRoom = priceOfRoom;
        this.dateOfRent = dateOfRent;
        this.nameCustomer = nameCustomer;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public long getPriceOfRoom() {
        return priceOfRoom;
    }

    public void setPriceOfRoom(long priceOfRoom) {
        this.priceOfRoom = priceOfRoom;
    }

    public int getDateOfRent() {
        return dateOfRent;
    }

    public void setDateOfRent(int dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    @Override
    public String toString() {
        return "Room " + idRoom +
                ": Type: " + typeOfRoom +
                ", Price: " + priceOfRoom + " đồng" +
                ", Date of rent: " + dateOfRent + " ngày" +
                ", Customer: " + nameCustomer;
    }
}
