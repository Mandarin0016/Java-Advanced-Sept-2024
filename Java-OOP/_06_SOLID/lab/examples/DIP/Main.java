package examples.DIP;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        Application application1 = new Application(new MySQL());
        Application application2 = new Application(new Postgres());


    }
}
