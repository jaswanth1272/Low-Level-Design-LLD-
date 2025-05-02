package LRU_Cache;

public class Main {
    public static void run() {
        LruCache<Integer, String> lrcache = new LruCache<>(3);

        lrcache.put(1, "Value 1");
        lrcache.put(2, "Value 2");
        lrcache.put(3, "Value 3");

        System.out.println(lrcache.get(1)); // Output: Value 1
        System.out.println(lrcache.get(2)); // Output: Value 2

        lrcache.put(4, "Value 4");

        System.out.println(lrcache.get(3)); // Output: null
        System.out.println(lrcache.get(4)); // Output: Value 4

        lrcache.put(2, "Updated Value 2");

        System.out.println(lrcache.get(1)); // Output: Value 1
        System.out.println(lrcache.get(2)); // Output: Updated Value 2
    }

    public static void main(String[] args) {
        run();
    }
}
