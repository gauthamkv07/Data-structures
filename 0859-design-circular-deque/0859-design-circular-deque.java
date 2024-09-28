class Node {
    int value;
    Node prev, next;

    public Node(int value) {
        this.value = value;
    }
}

class MyCircularDeque {
    int size, capacity;
    Node head, tail;

    public MyCircularDeque(int k) {
        capacity = k;
        size = 0;
        head = new Node(-1);
        tail = new Node(-1);

        head.next = tail;
        tail.prev = head;

        head.prev = null;
        tail.next = null;
    }
    
    public boolean insertFront(int value) {
        if(size == capacity) return false;
        Node node = new Node(value);

        node.next = head.next;
        node.prev = head;

        head.next = node;
        node.next.prev = node;

        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size == capacity) return false;
        Node node = new Node(value);

        node.next = tail;
        node.prev = tail.prev;

        tail.prev = node;
        node.prev.next =  node;

        size++;

        return true;      
    }
    
    public boolean deleteFront() {
        if(size == 0) return false;
        head.next = head.next.next;
        head.next.prev = head;

        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(size == 0) return false;

        tail.prev = tail.prev.prev;
        tail.prev.next = tail;

        size--;
        return true;
    }
    
    public int getFront() {
        if(size == 0) return -1;
        return head.next.value;
    }
    
    public int getRear() {
        if(size == 0) return -1;
        return tail.prev.value;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */