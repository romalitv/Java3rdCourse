import java.util.Random;

public class Main {
    public static float[][] createMatrix(int cols, int rows) {
        if (cols <= 0 || rows <= 0) {
            System.out.println("Error. Columns and(or) rows must be more than 0");
            return null;
        }

        float[][] matrix = new float[rows][cols];

        float value = 1;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }

        return matrix;
    }

    public static void fillingMatrixRandom(float[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix doesn't exist");
            return;
        }
        Random values = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = values.nextFloat(1000);
            }
        }
    }

    public static void multiplyConst(float[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix doesn't exist");
            return;
        }

        int constant = 3;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = constant * matrix[i][j];
            }
        }

    }

    public static float sumMaxEven(float[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Матриця не існує або має неправильний розмір.");
            return 0;
        }

        float sum;
        sum = 0;

        // Обчислення суми найбільших елементів в стовпцях з парними номерами
        for (int j = 0; j < matrix[0].length; j += 2) {
            float max = matrix[0][j];
            for (int i = 1; i < matrix.length; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            sum += max;
        }

        return sum;
    }

    public static float sumMinOdd(float[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Матриця не існує або має неправильний розмір.");
            return 0;
        }

        float sum = 0;

        // Обчислення суми найбільших елементів в стовпцях з парними номерами
        for (int j = 1; j < matrix[0].length; j += 2) {
            float max = matrix[0][j];
            for (int i = 1; i < matrix.length; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            sum += max;
        }

        return sum;
    }

    public static void main(String[] args) {

        int columns = 3;
        int rows = 4;

        float[][] resultMatrix = createMatrix(columns, rows);

        // Заповнення матриці випадковими значеннями
        fillingMatrixRandom(resultMatrix);

        multiplyConst(resultMatrix);

        // Виведення матриці на екран
        if (resultMatrix != null) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(resultMatrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(" ");
        }

        multiplyConst(resultMatrix);

        if (resultMatrix != null) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(resultMatrix[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("\n");
        }

        System.out.println("Max = " + sumMaxEven(resultMatrix));
        System.out.println("Min = " + sumMinOdd(resultMatrix));
        System.out.println("Sum = " + (sumMaxEven(resultMatrix) + sumMinOdd(resultMatrix)));


    }
}

