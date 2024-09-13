public class MainLab2 {

    public static void main(String[] args) {

        int[] array = new int[4];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;

        // 1. Създавам матрица с 3 реда и 4 колони за всеки един ред
        int[][] matrix = new int[3][4];

        // 1. Достъпвам клетка в матрицата
        // matrix[индекс на реда][индекс на клетката/колоната за този ред]
        matrix[1][2] = 7;
        int number = matrix[1][2];

        // достъпвам ред от матрица
        matrix[0] = new int[]{2, 3, 5, 6};
        for (int col = 0; col <= matrix[0].length - 1; col++) {
            System.out.print(matrix[0][col] + " ");
        }
        System.out.println();

        // 2. Обхождам матрица
        for (int col = 0; col < array.length; col++) {
            System.out.println(array[col]);
        }

        int counter = 1;
        // 1ва стъпка - обхождам всеки един ред 
        // - от първи ред = ред с индекс 0
        // - до последен ред = ред с индекс броят на редовете - 1
        // matrix.length = броят на редовете в матрицата
        for (int row = 0; row <= matrix.length - 1; row++) {

            // 2ра стъпка - обхождам всяка една колона на този ред
            // - от първа колона = колона с индекс 0
            // - до последна колона = дължината на реда - 1
            // matrix[индекс на реда].length = броят колони на този ред
            for (int col = 0; col <= matrix[row].length - 1; col++) {

                matrix[row][col] = counter++;
            }
        }

        for (int row = 0; row <= matrix.length - 1; row++) {

            for (int col = 0; col <= matrix[row].length - 1; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }
}