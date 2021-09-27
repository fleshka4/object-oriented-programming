package lab2;

import lab2.exceptions.FileNotExistException;
import lab2.exceptions.InvalidSizeException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataValidator {
    private final File file;
    private final static int MIN_SIZE = 1;
    private final static int MAX_SIZE = 1000000;

    public DataValidator(String path) {
        file = new File(path);
    }

    public int getSizeMatrix() throws FileNotExistException, FileNotFoundException {
        if (!file.exists()) {
            throw new FileNotExistException("File not exists");
        }
        final int n;
        try (Scanner scanner = new Scanner(file)) {
            n = Integer.parseInt(scanner.nextLine());
        }
        if (n < MIN_SIZE) {
            throw new InvalidSizeException("N < 1");
        }
        if (n > MAX_SIZE) {
            throw new InvalidSizeException("N > 1000000");
        }
        return n;
    }
}
