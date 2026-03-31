package entity;

public class Address {

    private int addressId;
    private String street;
    private String houseNumber;
    private String apartment;

    public Address() {
    }

    public Address(int addressId, String street, String houseNumber, String apartment) {
        this.addressId = addressId;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartment = apartment;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}