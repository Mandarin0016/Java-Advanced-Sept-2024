package examples.LSP;

import javax.naming.OperationNotSupportedException;

public class Robot extends Worker {

    @Override
    public void getFoodFromTheKitchen() {
        // 1 min
    }

    // Ами робота не може да тича до масата!!!
    @Override
    public void runToTheTable() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }
}
