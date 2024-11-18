package org.example.mockito;

public class GreetingGenerator {

    private Time time;

    public GreetingGenerator(Time time) {
        this.time = time;
    }

    public String getGreeting() {

        if (time.isMorning()) {
            return "Good morning!";
        } else {
            return "Have a nice day!";
        }
    }
}
