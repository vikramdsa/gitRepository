import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    public LocalTime currentTime;
    private List<Item> menu = new ArrayList<Item>();
    private List<OrderItem> orderItemList = new ArrayList<OrderItem>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        this.currentTime = getCurrentTime();
        if(currentTime.isAfter(this.openingTime) && currentTime.isBefore(this.closingTime) ){
            return true;
        } else {
            return false;
        }
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        return this.menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }

    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

//<<<<<<<<<<<<<<<<<<<<<<<OrderValue>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    public List<OrderItem> getOrderItemList() {
        return this.orderItemList;
    }

    private OrderItem findOrderItemByName(String orderItemName){
        for(OrderItem orderItem: orderItemList) {
            if(orderItem.getOrderName().equals(orderItemName))
                return orderItem;
        }
        return null;
    }

    public void addToOrder(String name, int price) {
        OrderItem newOrderItem = new OrderItem(name,price);
        orderItemList.add(newOrderItem);
    }

    public void removeFromOrder(String orderItemName) throws orderItemNotFoundException {
        OrderItem orderItemToBeRemoved = findOrderItemByName(orderItemName);
        if (orderItemToBeRemoved == null)
            throw new orderItemNotFoundException(orderItemName);

        orderItemList.remove(orderItemToBeRemoved);
    }

    public int orderValue() {
        int orderPrice=0;

        for(OrderItem orderItem: orderItemList) {
            orderPrice+=orderItem.getOrderPrice();
        }
        return orderPrice;
    }
//<<<<<<<<<<<<<<<<<<<<<<<OrderValue>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
