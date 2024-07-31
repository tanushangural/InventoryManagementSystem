public class ConsoleNotification implements Notification{
    @Override
    public void notify(Product product) {
        System.out.println("\n Notification: \n Product: "+product.getName()+"'s quantity is "+product.getQuantity()+ " less than minimum threshold \n");
    }
}
