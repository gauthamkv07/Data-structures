class LRUCache {

    class Node {
        int key, val;

        Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int size, capacity;
    HashMap<Integer, Node> cache;
    Node head, tail;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        cache = new HashMap<>();

        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.prev = null;
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next = node;
        node.next.prev = node;
    }

    private void removeNode(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        next.prev = prev;
        prev.next = next;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private void pop() {
        int key = tail.prev.key;
        Node node = cache.get(key);
        cache.remove(key);
        removeNode(node);
        size--;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            moveToHead(node);
            return;
        }

        Node node = new Node(key, value);
        addNode(node);
        cache.put(key, node);
        size++;
        if(size > capacity) pop();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */