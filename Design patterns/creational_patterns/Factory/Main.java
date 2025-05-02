public class Main {
    public static void main(String[] args) {
        Notification nf = NotificationFactory.createNotification("email");
        nf.notifyUser();
    }
}
