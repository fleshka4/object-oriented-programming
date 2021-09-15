package lab2;

import lab2.exceptions.DivisionByZeroException;

public class Matrix {
    private final int[][] matrix;

    public Matrix(int n) {
        matrix = new int[n + 2][n + 2];
        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix.length - 1; j++) {
                matrix[i][j] = (int) (Math.random() * 2 * n - n);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix.length - 1; j++) {
                string.append(matrix[i][j]).append(' ');
            }
            string.append('\n');
        }
        return String.valueOf(string);
    }

    private int[][] createCopyAndDivide() {
        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix.length - 1; j++) {
                int temp = matrix[i + 1][j] + matrix[i][j + 1] + matrix[i - 1][j] + matrix[i][j - 1];
                if (temp == 0) {
                    throw new DivisionByZeroException("Cannot divide by zero");
                }
                matrix[i][j] /= temp;
            }
        }

        final int[][] matrixCopy = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, matrixCopy[i], 0, matrix.length);
        }
        return matrixCopy;
    }

    public void rotate90() {
        final int[][] matrixCopy = createCopyAndDivide();

        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix.length - 1; j++) {
                matrix[i][j] = matrixCopy[j][matrix.length - i - 1];
            }
        }
    }
}
