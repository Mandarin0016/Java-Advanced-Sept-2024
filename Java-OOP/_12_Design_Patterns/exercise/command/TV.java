package command;

public class TV implements Receiver{

    @Override
    public void switchOn() {
        System.out.println("Switch on TV!");
    }
}
