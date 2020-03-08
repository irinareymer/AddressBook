package addressBook;

import java.util.*;

public class Book {
    private Map<String, Address> book = new HashMap<>();

    public void setBook(String name, Address address){
        book.put(name, address);
    }

    public void removePerson(String name){
        book.remove(name);
    }

    public void changeAddress(String name, Address newAddress){
        book.replace(name, newAddress);
    }

    public Address getAddressByName(String name){
        return book.get(name);
    }

    public List<String> findByStreet(String street){
        List<String> listOfP = new ArrayList<>();
        book.forEach((name, address) -> {
            if (address.getStreet().equals(street)) listOfP.add(name);
        } );
        return listOfP;
    }

    public List<String> findByHouse(int house){
        List<String> listOfP = new ArrayList<>();
        book.forEach((name, address) -> {
            if (address.getHouse() == house) listOfP.add(name);
        } );
        return listOfP;
    }

    @Override
    public String toString(){
        final String[] res = {""};
        book.forEach((name, address) -> res[0] += "name: " + name + "; " + address.toString() + "\n");
        return res[0];
    }

    public Map<String, Address> getBook() {
        return book;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Book other = (Book) obj;
        return book.hashCode() == other.getBook().hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(book);
    }
}
