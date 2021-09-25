package lab3.queue.exceptions;

import javax.naming.SizeLimitExceededException;

public class QueueUnderflowException extends SizeLimitExceededException {
    public QueueUnderflowException(String message) {
        super(message);
    }
}
