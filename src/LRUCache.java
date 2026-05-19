import java.util.HashMap;

class LRUCache {
    HashMap<Integer, Node> elements;
    Node head = new Node();
    Node tail = new Node();
    int initialCapacity;

    public LRUCache(int capacity) {
        initialCapacity = capacity;
        elements = new HashMap<>(initialCapacity);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!elements.containsKey(key)) return -1;

        Node node = elements.get(key);

        removeFromMiddle(node);

        insertToHead(node);

        return node.value;
    }

    private void insertToHead(Node node) {
        node.next = head.next;
        node.prev = head;

        node.next.prev = node;
        head.next = node;
    }

    private static void removeFromMiddle(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        if (elements.containsKey(key)) {

            Node node = elements.get(key);

            node.value = value;

            removeFromMiddle(node);

            insertToHead(node);

        } else {
            if (elements.size() >= initialCapacity) {
                elements.remove(tail.prev.key);

                removeFromMiddle(tail.prev);

                Node newNode = createNewNode(key, value);

                elements.put(key, newNode);

            } else {
                Node newNode = createNewNode(key, value);

                elements.put(key, newNode);
            }
        }
    }

    private Node createNewNode(int key, int value) {
        Node node = new Node();
        node.key = key;
        node.value = value;

        insertToHead(node);

        return node;
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

}