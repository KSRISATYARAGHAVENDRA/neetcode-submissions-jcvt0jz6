public class Node{
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
    }
class LRUCache {

    private Map<Integer, Node> map;
    private Node head, tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        this.head = new Node(0,0);
        this.tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }

    public void insert(Node node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.value;        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            
            remove(node);
            insert(node);

            node.value = value;
            return;
        }
        Node node = new Node(key, value);
        
        map.put(key, node);
        insert(node);

        if(map.size() > capacity){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
