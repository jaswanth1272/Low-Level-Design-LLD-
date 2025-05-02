public class Singleton {
    private static Singleton instance = null;

    private Singleton() {} // private constructor so that no object can be created outside

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

