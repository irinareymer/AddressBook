public class Address {
    public String street;
    public int house;
    public int apartment;

    public Address(String street, int house, int apartment) {
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    @Override
    public String toString(){
        return " street is " + street +
                " house is " + house +
                " apartment is " + apartment;
    }


}
