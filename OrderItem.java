public class OrderItem {
    private String name;
    private int price;

    public OrderItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getOrderName() {
        return name;
    }
    public int getOrderPrice() {
        return price;
    }

}
