public class trr { //временно вместо тестов
    public static void main(String[] args) {
        Name name1 = new Name("qwerty");
        System.out.println(name1);
        Address address1 = new Address("dfgg", 12, 3);
        System.out.println(address1);

        Name name2 = new Name("qwe");
        System.out.println(name2);
        Address address2 = new Address("asdf", 12, 5);
        System.out.println(address2);

        Book book = new Book();
        book.setBook(name1, address1);
        book.setBook(name2, address2);
        System.out.println(book);

        Address newAddress = new Address("asdf", 13, 5);
        book.changeAddress(name1, newAddress);

        book.removePerson(name2, address2);

        book.getAddress(name1);

        System.out.println(book);

    }
}
