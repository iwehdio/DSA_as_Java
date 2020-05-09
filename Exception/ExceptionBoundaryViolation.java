package Exception;

public class ExceptionBoundaryViolation extends RuntimeException {
    public ExceptionBoundaryViolation(String error){
        super(error);
    }
}
