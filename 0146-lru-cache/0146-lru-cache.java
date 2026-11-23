class LRUCache {

    class Node {
        Node next, prev;
        int key, value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        private void updateValue(int value) {
            this.value = value;
        }
    }

    Map<Integer, Node> cache;
    int size, capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        size = 0;
        this.capacity = capacity;

        head = new Node(-1,-1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
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
        Node node = tail.prev;
        cache.remove(key);
        removeNode(node);
        size--;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.updateValue(value);
            moveToHead(node);
            return;
        }
        
        Node node = new Node(key, value);
        cache.put(key, node);
        addNode(node);
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