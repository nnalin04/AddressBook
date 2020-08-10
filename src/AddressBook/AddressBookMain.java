package AddressBook;

import java.util.*;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome to AddressBook");

        Map<String, List<Object>> addressBook = new TreeMap<>();

        editingAddressBook(addressBook, sc);

    }

    /**
     * function to decide if we want to edit something in the address book.
     * 
     * @param addressBook map containing the info of the contact Person
     * @return addressBook
     */
    private static Map<String, List<Object>> editingAddressBook(Map<String, List<Object>> addressBook, Scanner sc) {

        System.out.println("\nwant to edit the Address Book");
        System.out.println("enter true for Yes or false for No");
        boolean choice = sc.nextBoolean();
        if (choice) {

            System.out.println("If you want to Add something enter true");
            System.out.println("If you want to edit the existing record enter false");
            boolean editChoice = sc.nextBoolean();
            if (editChoice) {
                addPerson(addressBook, sc);
            } else {
                System.out.println("whose info you want to change");
                String name = sc.nextLine();
                editAddressBook(addressBook, sc, name);
            }

            System.out.println("want to do more editing");
            System.out.println("enter \"Y\" for Yes or \"N\" for No");
            boolean continueChoice = sc.nextBoolean();
            if (continueChoice) {
                editingAddressBook(addressBook, sc);
            }
        }

        return addressBook;
    }

    public static Map<String, List<Object>> addPerson(Map<String, List<Object>> addressBook, Scanner sc) {
        System.out.println("\nEnter the record accordingly as asked");

        System.out.print("\nfirstName :- ");
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
        Integer phone = sc.nextInt();

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

    public static Map<String, List<Object>> editAddressBook(Map<String, List<Object>> addressBook, Scanner sc,
            String name) {

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
                String newAddress = sc.nextLine();
                addressBook.put(name, (List<Object>) addressBook.get(name).set(2, newAddress));
                break;
            case 2:
                System.out.println("Enter the new city");
                String newCity = sc.nextLine();
                addressBook.put(name, (List<Object>) addressBook.get(name).set(2, newCity));
                break;
            case 3:
                System.out.println("Enter the new state");
                String newState = sc.nextLine();
                addressBook.put(name, (List<Object>) addressBook.get(name).set(2, newState));
                break;
            case 4:
                System.out.println("Enter the new zip");
                Integer newZip = sc.nextInt();
                addressBook.put(name, (List<Object>) addressBook.get(name).set(2, newZip));
                break;
            case 5:
                System.out.println("Enter the new phone");
                Integer newPhone = sc.nextInt();
                addressBook.put(name, (List<Object>) addressBook.get(name).set(2, newPhone));
                break;
            default:
                // code block
        }
        System.out.println("want to do more editing");
        System.out.println("enter \"Y\" for Yes or \"N\" for No");
        String continueChoice = sc.nextLine();
        if (continueChoice == "Y") {
            editAddressBook(addressBook, sc, name);
        }

        return addressBook;

    }
}