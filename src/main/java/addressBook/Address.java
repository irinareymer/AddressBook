package addressBook;

import java.util.Objects;

public class Address {
    private String street;
    private int house;
    private int apartment;

    public Address(String street, int house, int apartment) {
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }
    public String getStreet(){
        return street;
    }
    public int getHouse(){
        return house;
    }

    @Override
    public String toString(){
        return "street: " + street + "; "+
                "house: " + house + "; "+
                "apartment: " + apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return house == address.house &&
                apartment == address.apartment &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, house, apartment);
    }
}
