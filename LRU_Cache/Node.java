package LRU_Cache;

class Node<K, V> {
    final K key;
    V value;
    Node<K, V> prev;
    Node<K, V> next;

    public Node(K key, V value)
    {
        this.key=key;
        this.value=value;
    }
}
