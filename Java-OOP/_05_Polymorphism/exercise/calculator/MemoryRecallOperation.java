package calculator;

public class MemoryRecallOperation implements Operation{

    private MemorySaveOperation memorySaveOperation;

    public MemoryRecallOperation(MemorySaveOperation memorySaveOperation) {
        this.memorySaveOperation = memorySaveOperation;
    }

    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
        return this.memorySaveOperation.getResult();
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
