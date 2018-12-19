package nc.rest.exception;

public class OrderNotFoundException extends RuntimeException {

    private final int orderId;

    public OrderNotFoundException(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String getMessage() {
        return "Order with id = " + orderId + " not found";
    }
}
