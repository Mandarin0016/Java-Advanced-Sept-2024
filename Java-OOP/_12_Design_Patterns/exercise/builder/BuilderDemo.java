package builder;

import java.util.*;

public class BuilderDemo {

    private static final String CREATE_COMMAND = "CREATE";
    private static final String CONTACT_INFO_COMMAND = "INFO";
    private static final String DELETE_CONTACT_COMMAND = "DELETE";
    private static final String PHONEBOOK_COMMAND = "PHONEBOOK";
    private static final String END_COMMAND = "END";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Phonebook phonebook = new Phonebook();

        while (!END_COMMAND.equals(input)) {
            switch (input) {
                case CREATE_COMMAND:
                    List<String> contactInfo = readContactInfo(scanner);

                    Contact contact = new Contact.Builder(contactInfo.get(0), contactInfo.get(1))
                    .withCompany(contactInfo.get(2))
                    .withTitle(contactInfo.get(3))
                    .build();

                    phonebook.addContact(contact);

                    break;
                case CONTACT_INFO_COMMAND:
                    contact = phonebook.getContactByName(scanner.nextLine());
                    System.out.println(contact);
                    break;
                case DELETE_CONTACT_COMMAND:
                    phonebook.deleteContactByName(scanner.nextLine());
                    break;
                case PHONEBOOK_COMMAND:
                    phonebook.getAllContacts()
                             .forEach(System.out::println);
                    break;
            }


            input = scanner.nextLine();
        }


    }

    private static List<String> readContactInfo(Scanner input) {
        List<String> contactInfo = new ArrayList<>();

        System.out.print("Name: ");
        contactInfo.add(input.nextLine());

        System.out.print("Number: ");
        contactInfo.add(input.nextLine());

        System.out.print("Company: ");
        contactInfo.add(input.nextLine());

        System.out.print("Title: ");
        contactInfo.add(input.nextLine());

        System.out.print("Email: ");
        contactInfo.add(input.nextLine());

        System.out.print("Website: ");
        contactInfo.add(input.nextLine());

        System.out.print("Birthday: ");
        contactInfo.add(input.nextLine());

        return contactInfo;
    }
}
