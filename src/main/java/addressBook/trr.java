package addressBook;

public class trr { //временно вместо тестов
    public static void main(String[] args) {
        String name1 = new String("qwerty");
        System.out.println(name1);
        Address address1 = new Address("dfgg", 12, 3);
        System.out.println(address1);

        String name2 = new String("qwe");
        System.out.println(name2);
        Address address2 = new Address("asdf", 12, 5);
        System.out.println(address2);

        Book book = new Book();
        book.setBook(name1, address1);
        book.setBook(name2, address2);
        System.out.println(book);

        Address newAddress = new Address("asdf", 13, 5);
        book.changeAddress(name1, newAddress);
        book.removePerson(name2);

        System.out.println(book.getAddressByName(name1));

        System.out.println(book);

        Book book2 = new Book();
        Book book3 = new Book();

        book2.setBook(name1, address1);
        book3.setBook(name1, address1);

        /*System.out.println(book2.getBook().hashCode());
        System.out.println(book3.getBook().hashCode());
        System.out.println(book.getBook().hashCode());*/

        System.out.println(book.findByHouse(13));
        System.out.println(book.findByStreet("asdf"));

    }
}
