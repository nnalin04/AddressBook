package AddressBook;

import java.util.*;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to AddressBook");

        Map<String, List<Object>> addressBook = new TreeMap<>();

        addPerson(addressBook);

    }
    

    public static Map<String, List<Object>> addPerson(Map<String, List<Object>> addressBook) {
        String firstName;
        String lastName;
        String address;
        String city;
        String state;
        Integer zip;
        Integer phone;

        List<Object> ContactPerson = new ArrayList<>();
        ContactPerson.add(firstName);
        ContactPerson.add(lastName);
        ContactPerson.add(address);
        ContactPerson.add(city);
        ContactPerson.add(state);
        ContactPerson.add(zip);
        ContactPerson.add(phone);

        String name = firstName + " " + lastName;

        addressBook.put(name, ContactPerson);

        return addressBook;

    }
}