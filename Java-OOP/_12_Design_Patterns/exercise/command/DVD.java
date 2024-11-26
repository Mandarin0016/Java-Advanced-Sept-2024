package command;

public class DVD implements Receiver {

    @Override
    public void switchOn() {
        System.out.println("Switch on DVD!");
    }
}
