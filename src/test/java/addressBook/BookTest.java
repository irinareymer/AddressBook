package addressBook;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Address address1 = new Address("Right", 12, 3);
    Address address2 = new Address("Left", 13, 3);

    @Test
    void setBook() {
        Book actual = new Book();
        actual.setBook("Ann",address1);
        actual.setBook("Dan",address2);
        assertEquals("name: Ann; street: Right; house: 12; apartment: 3\n" +
                "name: Dan; street: Left; house: 13; apartment: 3\n", actual.toString());
    }

    @Test
    void removePerson() {
        Book actual = new Book();
        actual.setBook("Ann",address1);
        actual.setBook("Dan",address2);
        actual.removePerson("");
        assertEquals("name: Ann; street: Right; house: 12; apartment: 3\n" +
                "name: Dan; street: Left; house: 13; apartment: 3\n", actual.toString());

        actual.removePerson("Dan");
        assertEquals("name: Ann; street: Right; house: 12; apartment: 3\n", actual.toString());
    }

    @Test
    void changeAddress() {
        Book actual = new Book();
        actual.setBook("Ann",address1);
        actual.changeAddress("Ann", address1);
        assertEquals("name: Ann; street: Right; house: 12; apartment: 3\n", actual.toString());

        actual.changeAddress("Ann", address2);
        assertEquals("name: Ann; street: Left; house: 13; apartment: 3\n", actual.toString());
    }

    @Test
    void getAddressByName() {
        Book actual = new Book();
        actual.setBook("Ann",address1);
        assertEquals("street: Right; house: 12; apartment: 3", actual.getAddressByName("Ann").toString());
    }

    @Test
    void findByStreet() {
        Book actual = new Book();
        actual.setBook("Ann",address1);
        actual.setBook("Dan",address2);
        assertEquals("[Ann]",actual.findByStreet("Right").toString());

        actual.changeAddress("Dan", address1);
        assertEquals("[Ann, Dan]",actual.findByStreet("Right").toString());

    }

    @Test
    void findByHouse() {
        Book actual = new Book();
        actual.setBook("Ann",address1);
        actual.setBook("Dan",address2);
        assertEquals("[Ann]",actual.findByHouse(12).toString());

        actual.changeAddress("Dan", address1);
        assertEquals("[Ann, Dan]",actual.findByHouse(12).toString());

    }
}