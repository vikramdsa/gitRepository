public class orderItemNotFoundException extends Throwable {
    public orderItemNotFoundException(String orderItemName) {
        super(orderItemName);
    }
}
