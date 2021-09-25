package lab3.queue.exceptions;

import javax.naming.SizeLimitExceededException;

public class QueueOverflowException extends SizeLimitExceededException {
    public QueueOverflowException(String message) {
        super(message);
    }
}
