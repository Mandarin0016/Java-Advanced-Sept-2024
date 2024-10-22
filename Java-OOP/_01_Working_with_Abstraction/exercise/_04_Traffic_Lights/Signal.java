package _04_Traffic_Lights;

public enum Signal {
    RED,
    GREEN,
    YELLOW;

    public static void updateSignal(Signal[] signals) {
        // red -> green -> yellow -> red
        for (int i = 0; i < signals.length; i++) {
            switch (signals[i]) {
                case RED -> signals[i] = Signal.GREEN;
                case GREEN -> signals[i] = Signal.YELLOW;
                case YELLOW -> signals[i] = Signal.RED;
            }
        }
    }

    public static void printSignals(Signal[] signals){
        for (Signal signal : signals) {
            System.out.print(signal + " ");
        }
        System.out.println();
    }
}
