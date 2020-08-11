package AddressBook;

import java.util.*;

public class Person {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    Integer zip;
    Long phone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }



    public Person() {
    }

    public Person(String firstName, String lastName, String address, String city, String state, Integer zip,
            Long phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "firstName: " + firstName + " \nlastName: " + lastName + " \naddress: " + address + " \ncity: " + city
                + " \nstate: " + state + " \nZip: " + zip + " \nphone: " + phone;
    }    
}
