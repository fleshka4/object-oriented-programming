package lab2.exceptions;

import java.io.IOException;

public class FileNotExistException extends IOException {
    public FileNotExistException(String message) {
        super(message);
    }
}
