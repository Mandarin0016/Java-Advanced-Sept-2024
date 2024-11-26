package command;

public class CommandDemo {

    public static void main(String[] args) {

        // On command for TV
        Receiver receiver = new TV();
        Command onCommand = new OnCommand(receiver);

        Invoker invoker = new Invoker(onCommand);
        invoker.execute();

        // On command for DVD
        receiver = new DVD();
        onCommand = new OnCommand(receiver);

        invoker = new Invoker(onCommand);
        invoker.execute();
    }
}
