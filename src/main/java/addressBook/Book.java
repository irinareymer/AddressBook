package addressBook;

import java.util.*;

public class Book {
    private Map<String, Address> book = new HashMap<>();

    public void addPersonAndAddress(String name, Address address){
        if (name.equals(""))
            throw new IllegalArgumentException("incorrect name");
        if (book.containsKey(name))
            throw new IllegalArgumentException("This person is already in book. You may changeAddress for this person.");
        if (address.getStreet().equals("") || address.getHouse() <= 0 || address.getApartment() <= 0)
            throw new IllegalArgumentException("incorrect address");
        book.put(name, address);
    }

    public void removePerson(String name){
        if (!book.containsKey(name))
            throw new IllegalArgumentException("Can`t find person in book. You can`t remove.");
        book.remove(name);
    }

    public void changeAddress(String name, Address newAddress){
        if (!book.containsKey(name))
            throw new IllegalArgumentException("Can`t find person in book. You may addPersonAndAddress.");
        if (newAddress.getStreet().equals("") || newAddress.getHouse() <= 0 || newAddress.getApartment() <= 0)
            throw new IllegalArgumentException("incorrect address");
        book.replace(name, newAddress);
    }

    public Address getAddressByName(String name){
        if (!book.containsKey(name))
            throw new IllegalArgumentException("Can`t find person in book. You may addPersonAndAddress.");
        return book.get(name);
    }

    public List<String> findByStreet(String street){
        if (street.equals(""))
            throw new  IllegalArgumentException("incorrect street");
        List<String> listOfP = new ArrayList<>();
        book.forEach((name, address) -> {
            if (address.getStreet().equals(street)) listOfP.add(name);
        } );
        return listOfP;
    }

    public List<String> findByHouse(String street, int house){
        if (street.equals("") || house <= 0)
            throw new  IllegalArgumentException("incorrect street or house");
        List<String> listOfP = new ArrayList<>();
        book.forEach((name, address) -> {
            if (address.getStreet().equals(street) && address.getHouse() == house) listOfP.add(name);
        } );
        return listOfP;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        for (Map.Entry<String, Address> k: book.entrySet()){
            res.append("name: ").append(k.getKey()).append("; ").append(k.getValue()).append(System.lineSeparator());
        }
        return res.toString();
    }

    Map<String, Address> getBook() {
        return book;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Book other = (Book) obj;
        for(Map.Entry<String, Address> k: book.entrySet())
            if (other.getBook().getOrDefault(k.getKey(), k.getValue()) == k.getValue()) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(book);
    }
}
