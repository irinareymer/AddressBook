package addressBook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Address address1 = new Address("Right", 12, 3);
    Address address2 = new Address("Left", 13, 3);

    @Test
    void addPersonAndAddress() {
        Book actual = new Book();
        actual.addPersonAndAddress("Ann",address1);
        actual.addPersonAndAddress("Dan",address2);
        Book expected = new Book();
        expected.getBook().put("Ann", address1);
        expected.getBook().put("Dan", address2);
        assertEquals(expected, actual);
        System.out.print(actual.toString() + System.lineSeparator());

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                actual.addPersonAndAddress("Ann",address2));
        System.out.print(actual.toString() + System.lineSeparator());

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                actual.addPersonAndAddress("Vic", new Address("Mid",-12,0)));
        System.out.print(actual.toString() + System.lineSeparator());

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                actual.addPersonAndAddress("", address1));
        System.out.print(actual.toString() + System.lineSeparator());
    }

    @Test
    void removePerson() {
        Book actual = new Book();
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                actual.removePerson("Dan"));

        actual.addPersonAndAddress("Ann",address1);
        actual.addPersonAndAddress("Dan",address2);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                actual.removePerson(""));
        System.out.print(actual.toString() + System.lineSeparator());

        Book expected = new Book();
        expected.getBook().put("Ann", address1);
        actual.removePerson("Dan");
        assertEquals(expected, actual);
        System.out.print(actual.toString() + System.lineSeparator());
    }

    @Test
    void changeAddress() {
        Book actual = new Book();
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                actual.changeAddress("Dan",address1));

        actual.addPersonAndAddress("Ann",address1);
        actual.changeAddress("Ann", address1);
        Book expected = new Book();
        expected.getBook().put("Ann", address1);
        assertEquals(expected,actual);
        System.out.print(actual.toString() + System.lineSeparator());

        actual.changeAddress("Ann", address2);
        expected.getBook().replace("Ann",address1,address2);
        assertEquals(expected,actual);
        System.out.print(actual.toString() + System.lineSeparator());

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                actual.changeAddress("Ann", new Address("Mid",-12,0)));
        System.out.print(actual.toString() + System.lineSeparator());
    }

    @Test
    void getAddressByName() {
        Book actual = new Book();
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                actual.getAddressByName("Dan"));

        Book expected = new Book();
        actual.addPersonAndAddress("Ann",address1);
        expected.getBook().put("Ann",address1);
        assertEquals(expected.getBook().get("Ann"),actual.getAddressByName("Ann"));
        System.out.print(actual.getAddressByName("Ann").toString() + System.lineSeparator());
    }

    @Test
    void findByStreet() {
        Book actual = new Book();
        List<String> actualList;
        actual.addPersonAndAddress("Ann",address1);
        actual.addPersonAndAddress("Dan",address2);

        actualList = actual.findByStreet("Right");
        List<String> expectedList = new ArrayList<>();
        expectedList.add("Ann");
        assertEquals(expectedList, actualList);
        System.out.print(actualList + System.lineSeparator());
        expectedList.clear();

        actual.changeAddress("Dan",address1);
        actualList = actual.findByStreet("Right");
        expectedList.add("Ann");
        expectedList.add("Dan");
        assertEquals(expectedList,actualList);
        System.out.print(actualList + System.lineSeparator());
        expectedList.clear();

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                actual.findByStreet(""));
    }

    @Test
    void findByHouse() {
        Book actual = new Book();
        List<String> actualList;
        actual.addPersonAndAddress("Ann",address1);
        actual.addPersonAndAddress("Dan",address1);

        actualList = actual.findByHouse("Right",12);
        List<String> expectedList = new ArrayList<>();
        expectedList.add("Ann");
        expectedList.add("Dan");
        assertEquals(expectedList,actualList);
        System.out.print(actualList + System.lineSeparator());
        expectedList.clear();

        actual.changeAddress("Dan", address2);
        actualList = actual.findByHouse("Right",12);
        expectedList.add("Ann");
        assertEquals(expectedList,actualList);
        System.out.print(actualList + System.lineSeparator());
        expectedList.clear();

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                actual.findByHouse("Mid", -12));
    }
}