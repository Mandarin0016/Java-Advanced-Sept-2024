package examples.LSP;

import javax.naming.OperationNotSupportedException;

public class Restaurant {

    public static void processOrder(Worker worker) throws OperationNotSupportedException {
        worker.takeOrder();
        worker.getFoodFromTheKitchen();
        worker.runToTheTable();
        worker.leaveTheFood();
    }
}
