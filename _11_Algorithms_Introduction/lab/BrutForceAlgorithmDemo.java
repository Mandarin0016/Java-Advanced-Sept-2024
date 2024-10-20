public class BrutForceAlgorithmDemo {

    public static void main(String[] args) {

        //{0-9}{0-9}{0-9}{0-9}{0-9}

        String pin = "99999";
        int count = 0;

        for (int first = 0; first <= 9; first++) {
            for (int second = 0; second <= 9; second++) {
                for (int third = 0; third <= 9; third++) {
                    for (int fourth = 0; fourth <= 9; fourth++) {
                        for (int fifth = 0; fifth <= 9; fifth++) {
                            String combination = String.format("%d%d%d%d%d", first, second, third, fourth, fifth);
                            count++;
                            if (combination.equals(pin)) {
                                System.out.println("Congrats! You made it! Combination number: " + count);
                                return;
                            }
                        }
                    }
                }
            }
        }

    }
}
