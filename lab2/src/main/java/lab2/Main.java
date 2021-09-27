package lab2;

import lab2.exceptions.InvalidSizeException;
import lab2.exceptions.DivisionByZeroException;

import java.io.*;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final DataValidator dataValidator = new DataValidator(br.readLine());

            final Matrix matrix = new Matrix(dataValidator.getSizeMatrix());
            try (FileWriter writer = new FileWriter("matrix.txt")) {
                writer.write(matrix + "\n\n");
                for (int i = 0; i < 3; i++) {
                    matrix.rotate90();
                    writer.write(matrix + "\n");
                }
            }
        } catch (IOException | OutOfMemoryError | NoSuchElementException | NumberFormatException
                | InvalidSizeException | DivisionByZeroException e) {
            e.printStackTrace();
        }
    }
}
