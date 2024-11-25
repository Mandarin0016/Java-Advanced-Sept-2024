package Builder;

public class Main {

    public static void main(String[] args) {

        User user1 = new User().setAge(20).setEmail("email").setFirstName("Vik").setLastName("Aleksandrov");
        User user2 = new User().setAge(20).setEmail("email");
        User user3 = new User().setAge(20).setEmail("email").setCountry("Bulgaria");
        User user4 = new User().setAge(20).setEmail("email").setCity("Pleven");
        User user5 = new User().setFirstName("Vik").setLastName("Aleksandrov");

        System.out.println();

        StringBuilder sb = new StringBuilder();

        sb.append("I am ").append("from ").append("Bulgaria");

    }
}
