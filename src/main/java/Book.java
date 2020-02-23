import java.util.HashMap;
import java.util.Map;

public class Book {
    public Map<Name, Address> book = new HashMap<>();

    public void setBook(Name name, Address address){
        book.put(name, address);
    }

    public void changeAddress(Name oldName, Address newAddress){
        book.replace(oldName, newAddress);
    }

    public void removePerson(Name name, Address address){
        book.remove(name, address);
    }

    public void getAddress(Name name){
        book.get(name);
    }

    //public void find(int house){ }

    /*@Override
    public  String toString(){
    }*/
}
