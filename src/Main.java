public class Main {
    public static void main(String[] args) {
        Notification notification = new ConsoleNotification();
        Inventory inventory = new Inventory(notification, 2);
        TerminalInteractionUI terminalInteractionUI = new TerminalInteractionUI(inventory);
        terminalInteractionUI.start();
    }
}