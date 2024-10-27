package Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

    private String name;
    private final Person capitan;
    private final List<Person> people;

    public Team(String name, List<Person> people, Person capitan) {
        this.name = name;
        this.capitan = capitan;
        this.people = people;
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person getCapitan() {
        return capitan;
    }
}
