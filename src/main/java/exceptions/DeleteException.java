package exceptions;

public class DeleteException extends RuntimeException {

    private String message;
    private Integer code;

    public DeleteException(String message, Integer code) {
        super(message);
        this.message = message;
        this.code = code;
    }


}
