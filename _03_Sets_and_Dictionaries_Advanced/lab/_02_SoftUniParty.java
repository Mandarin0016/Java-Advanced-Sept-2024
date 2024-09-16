import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _02_SoftUniParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //7IK9Yo0h
        //9NoBUajQ
        //Ce8vwPmE
        //SVQXQCbc
        //tSzE5t0p
        //PARTY
        //9NoBUajQ
        //Ce8vwPmE
        //SVQXQCbc
        //END

        Set<String> regularGuests = new TreeSet<>();
        Set<String> vipGuests = new TreeSet<>();

        String input = scanner.nextLine();
        while (!input.equals("PARTY")) {

            char firstSymbol = input.charAt(0);
            if (Character.isDigit(firstSymbol)) {
                vipGuests.add(input);
            } else {
                regularGuests.add(input);
            }

            input = scanner.nextLine();
        }

        //9NoBUajQ
        //Ce8vwPmE
        //SVQXQCbc
        //END
        input = scanner.nextLine();
        while (!input.equals("END")) {
            regularGuests.remove(input);
            vipGuests.remove(input);
            input = scanner.nextLine();
        }

        System.out.println(regularGuests.size() + vipGuests.size());
        for (String vipGuest : vipGuests) {
            System.out.println(vipGuest);
        }
        for (String regularGuest : regularGuests) {
            System.out.println(regularGuest);
        }
    }
}
