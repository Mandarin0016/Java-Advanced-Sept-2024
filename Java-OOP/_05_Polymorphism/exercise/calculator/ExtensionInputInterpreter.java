package calculator;

public class ExtensionInputInterpreter extends InputInterpreter{

    private MemorySaveOperation memorySaveOperation;

    public ExtensionInputInterpreter(CalculationEngine engine) {
        super(engine);
        this.memorySaveOperation = new MemorySaveOperation();
    }

    @Override
    public Operation getOperation(String operation) {
        return switch (operation) {
            case "/" -> new DivideOperation();
            case "mr" -> new MemoryRecallOperation(memorySaveOperation);
            case "ms" ->this.memorySaveOperation;
            default -> super.getOperation(operation);
        };
    }
}
