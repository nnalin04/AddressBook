package AddressBook;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome to AddressBook");

        Map<String, Person> addressBook = new TreeMap<>();

        System.out.println("\nwant to edit the Address Book");
        System.out.println("enter true for Yes or false for No");
        boolean choice = sc.nextBoolean();
        if (choice) {
            addressBook = editingAddressBook(addressBook, sc);
        }

        if (!checkingForEquals(addressBook)) {
            System.out.println("there are duplicate name");
        }

        System.out.println("\nwant to view by choice  of city or state");
        System.out.println("enter true for Yes or false for No");
        boolean viewChoice = sc.nextBoolean();
        if (viewChoice) {
        viewByChoice(addressBook,sc);
        }

        System.out.println("\nwant to sort by different method ");
        System.out.println("enter true for Yes or false for No");
        boolean SortingChoice = sc.nextBoolean();
        if (SortingChoice) {
        sortingAddressBook(addressBook, sc);
        }else{
            printingAddressBook(addressBook);
        }

        grtSinglePersonInfo(addressBook, sc);

    }

    /**
     * function to search person in city or state.
     * @param addressBook
     * @param sc
     * @return
     */
    private static void grtSinglePersonInfo(Map<String, Person> addressBook, Scanner sc) {

        System.out.println("Enter 'C' for city");
        System.out.println("Enter 'S' for State");
        sc.nextLine();
        char choice = sc.next().charAt(0);
        if(choice == 'C'){
            Map<String, Person> cityAddressBook = new TreeMap<>();
            System.out.println("enter city");
            sc.nextLine();
            String city = sc.nextLine();
            for (String keyName : addressBook.keySet()){
                Person person = addressBook.get(keyName);
                boolean res = person.getCity().equals(city);
                if(res){
                    cityAddressBook.put(keyName,person);
                }
            }
            System.out.println("enter name to find");
            sc.nextLine();
            String name = sc.nextLine();
            if(cityAddressBook.containsKey(name)){
                System.out.println("person is present");
            }

        }else{
            Map<String, Person> stateAddressBook = new TreeMap<>();
            System.out.println("enter state");
            sc.nextLine();
            String state = sc.nextLine();
            for (String name : addressBook.keySet()){
                Person person = addressBook.get(name);
                boolean res = person.getState().equals(state);
                if(res){
                    stateAddressBook.put(name,person);
                }
            }
            System.out.println("enter name to find");
            sc.nextLine();
            String name = sc.nextLine();
            if(stateAddressBook.containsKey(name)){
                System.out.println("person is present");
            }
        }
    }

    private static void viewByChoice(Map<String, Person> addressBook, Scanner sc) {
        System.out.println("Enter 'C' for city");
        System.out.println("Enter 'S' for State");
        sc.nextLine();
        char choice = sc.next().charAt(0);
        if(choice == 'C'){
            System.out.println("enter city");
            sc.nextLine();
            String city = sc.nextLine();
            for (String name : addressBook.keySet()){
                Person person = addressBook.get(name);
                boolean result = person.getCity().equals(city);
                if(result){
                    System.out.println(person);
                }
            }
        }else{
            System.out.println("enter state");
            sc.nextLine();
            String state = sc.nextLine();
            for (String name : addressBook.keySet()){
                Person person = addressBook.get(name);
                boolean result = person.getState().equals(state);
                if(result){
                    System.out.println(person);
                }
            }
        }
    }

    private static void sortingAddressBook(Map<String, Person> addressBook, Scanner sc) {

        Map<String, Person> sorted = addressBook;

        System.out.println("What way do you want to sort");
        System.out.println("Alphabetically - 'A' ");
        System.out.println("city - 'C' ");
        System.out.println("state - 'S' ");
        System.out.println("zip - 'Z' ");

        char choice = sc.next().charAt(0);
        switch (choice) {
            case 'C':
                sorted = addressBook.entrySet().stream().sorted()
                        .collect(toMap(e -> e.getKey(), e -> e.getValue().getCity(), (e1, e2) -> (String) e2, LinkedHashMap::new));
                break;
            case 'S':
                sorted = addressBook.entrySet().stream().sorted()
                        .collect(toMap(e -> e.getKey(), e -> e.getValue().getState(), (e1, e2) -> (String) e2, LinkedHashMap::new));
                break;
            case 'Z':
                sorted = addressBook.entrySet().stream().sorted()
                        .collect(toMap(e -> e.getKey(), e -> e.getValue().getZip(), (e1, e2) -> (Integer) e2, LinkedHashMap::new));
                break;
            default:
        }

        printingAddressBook(sorted);

    }

    private static void printingAddressBook(Map<String, Person> addressBook) {
        for (String name : addressBook.keySet()) {
            Person person = addressBook.get(name);
            System.out.println(person);
        }
    }

    /**
     * function to decide if we want to edit something in the address book.
     *
     * @param addressBook map containing the info of the contact Person
     * @return addressBook
     */
    public static Map<String, Person> editingAddressBook(Map<String, Person> addressBook, Scanner sc) {

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
    public static Map<String, Person> addPerson(Map<String, Person> addressBook, Scanner sc) {
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

        String name = firstName + " " + lastName;

        addressBook.put(name, person);

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
    public static Map<String, Person> editAddressInfo(Map<String, Person> addressBook, Scanner sc, String name) {
        Person contactInfo = addressBook.get(name);

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
                contactInfo.setAddress(newAddress);
                addressBook.put(name, contactInfo);
                break;
            case 2:
                System.out.println("Enter the new city");
                sc.nextLine();
                String newCity = sc.nextLine();
                contactInfo.setCity(newCity);
                addressBook.put(name, contactInfo);
                break;
            case 3:
                System.out.println("Enter the new state");
                sc.nextLine();
                String newState = sc.nextLine();
                contactInfo.setState(newState);
                addressBook.put(name, contactInfo);
                break;
            case 4:
                System.out.println("Enter the new zip");
                sc.nextLine();
                Integer newZip = sc.nextInt();
                contactInfo.setZip(newZip);
                addressBook.put(name, contactInfo);
                break;
            case 5:
                System.out.println("Enter the new phone");
                sc.nextLine();
                Long newPhone = sc.nextLong();
                contactInfo.setPhone(newPhone);
                addressBook.put(name, contactInfo);
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

    public static boolean checkingForEquals(Map<String, Person> addressBook) {
        return addressBook.keySet().size() != addressBook.keySet().stream().distinct().count();
    }
}