package lab2;

import lab2.exceptions.FileNotExistException;
import lab2.exceptions.InvalidSizeException;
import lab2.exceptions.DivisionByZeroException;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            File file = new File(br.readLine());
            if (!file.exists()) {
                throw new FileNotExistException("File not exists");
            }
            final int n;
            try (Scanner scanner = new Scanner(file)) {
                 n = Integer.parseInt(scanner.nextLine());
            }
            if (n < 1) {
                throw new InvalidSizeException("N < 1");
            }
            if (n > 1000000) {
                throw new InvalidSizeException("N > 1000000");
            }
            Matrix matrix = new Matrix(n);
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
