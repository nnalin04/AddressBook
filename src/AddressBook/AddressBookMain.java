package AddressBook;

import java.util.*;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome to AddressBook");

        Map<String, List<Object>> addressBook = new HashMap<>();

        System.out.println("\nwant to edit the Address Book");
        System.out.println("enter true for Yes or false for No");
        boolean choice = sc.nextBoolean();
        if (choice) {
            addressBook = editingAddressBook(addressBook, sc);
        }

        checkingForEquals(addressBook);

    }

    /**
     * function to decide if we want to edit something in the address book.
     *
     * @param addressBook map containing the info of the contact Person
     * @return addressBook
     */
    public static Map<String, List<Object>> editingAddressBook(Map<String, List<Object>> addressBook, Scanner sc) {

        System.out.println("If you want to Add something enter \'A\'");
        System.out.println("If you want to edit the existing record enter \'E\'");
        System.out.println("If you want to delete an existing record enter \'D\'");
        char editChoice = sc.next().charAt(0);
        if (editChoice == 'A') {
            addPerson(addressBook, sc);
        } else if (editChoice == 'E') {
            System.out.println("whose info you want to change");
            sc.nextLine();
            String name = sc.nextLine();
            editAddressInfo(addressBook, sc, name);
        } else if (editChoice == 'D') {
            System.out.println("whose info you want to delete");
            sc.nextLine();
            String name = sc.nextLine();
            addressBook.remove(name);
        }

        System.out.println("want to do more any more changes in the Address Book");
        System.out.println("enter \'Y\' for Yes or \'N\' for No");
        char continueChoice = sc.next().charAt(0);

        if (continueChoice == 'Y') {
            editingAddressBook(addressBook, sc);
        }

        return addressBook;
    }

    /**
     * function to add a person in an addressBook.
     * 
     * @param addressBook
     * @param sc
     * @return addressBook with the new person.
     */
    public static Map<String, List<Object>> addPerson(Map<String, List<Object>> addressBook, Scanner sc) {
        System.out.println("\nEnter the record accordingly as asked");

        System.out.print("\nfirstName :- ");
        sc.nextLine();
        String firstName = sc.nextLine();

        System.out.print("\nlastName :- ");
        String lastName = sc.nextLine();

        System.out.print("\naddress :- ");
        String address = sc.nextLine();

        System.out.print("\nCity :- ");
        String city = sc.nextLine();

        System.out.print("\nState :- ");
        String state = sc.nextLine();

        System.out.print("\nzip code :- ");
        Integer zip = sc.nextInt();

        System.out.print("\nPhone :- ");
        Long phone = sc.nextLong();

        Person person = new Person(firstName, lastName, address, city, state, zip, phone);

        List<Object> ContactPerson = new ArrayList<>();
        ContactPerson.add(person);

        String name = firstName + " " + lastName;

        addressBook.put(name, ContactPerson);

        return addressBook;

    }

    /**
     * function to edit the existing info.
     * 
     * @param addressBook - current dictionary of addressBook
     * @param sc
     * @param name        - key used for map
     * @return addressBook.
     */
    public static Map<String, List<Object>> editAddressInfo(Map<String, List<Object>> addressBook, Scanner sc,
            String name) {
        List<Object> contactInfo = new ArrayList<>(addressBook.get(name));

        System.out.println("What do you want to edit");
        System.out.println("Enter \"1\" for address");
        System.out.println("Enter \"2\" for city");
        System.out.println("Enter \"3\" for state");
        System.out.println("Enter \"4\" for zip");
        System.out.println("Enter \"5\" for phone");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter the new address");
                sc.nextLine();
                String newAddress = sc.nextLine();
                contactInfo.set(2, newAddress);
                addressBook.replace(name, contactInfo);
                break;
            case 2:
                System.out.println("Enter the new city");
                sc.nextLine();
                String newCity = sc.nextLine();
                contactInfo.set(3, newCity);
                addressBook.put(name, contactInfo);
                break;
            case 3:
                System.out.println("Enter the new state");
                sc.nextLine();
                String newState = sc.nextLine();
                contactInfo.set(4, newState);
                addressBook.replace(name, contactInfo);
                break;
            case 4:
                System.out.println("Enter the new zip");
                sc.nextLine();
                Integer newZip = sc.nextInt();
                contactInfo.set(5, newZip);
                addressBook.replace(name, contactInfo);
                break;
            case 5:
                System.out.println("Enter the new phone");
                sc.nextLine();
                Long newPhone = sc.nextLong();
                contactInfo.set(6, newPhone);
                addressBook.replace(name, contactInfo);
                break;
            default:
                // code block
        }
        System.out.println("want to do more editing");
        System.out.println("enter \"Y\" for Yes or \"N\" for No");
        char continueChoice = sc.nextLine().charAt(0);
        if (continueChoice == 'Y') {
            editAddressInfo(addressBook, sc, name);
        }

        return addressBook;

    }

    public static boolean checkingForEquals(Map<String, List<Object>> addressBook) {
        return addressBook.keySet().size() != addressBook.keySet().stream().distinct().count();
    }
}
