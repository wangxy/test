package main.java.algorithms.src;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map;
    Node head;
    Node tail;

    int capacity;
    int size;

    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
        size = 0;

        head = null;
        tail = null;
    }

    private void moveNodeFirst(Node r) {
        if (r.prev != null) {
            if (r.next != null) {
                r.prev.next = r.next;
                r.next.prev = r.prev;
            } else {
                // is the last one.
                r.prev.next = null;
                tail = r.prev;
            }
            // put r to head;
            r.next = head;
            head.prev = r;
            r.prev = null;
            head = r;
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node r = map.get(key);
            moveNodeFirst(r);
            return r.val;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (size == capacity && !map.containsKey(key)) {
            // require remove and old entry
            Node n = tail;
            map.remove(n.key);
            if (n.prev == null) {
                tail = null; head = null;
            } else {
                tail = n.prev;
                n.prev.next = null;
                n.prev = null;
            }
        }

        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.val = value;
            moveNodeFirst(n);
        } else {
            // add new node
            Node n = new Node(key, value);
            if (head == null) {
                head = n; tail = n;
            } else {
                n.next = head;
                head.prev = n;
                head = n;
            }
            map.put(key, n);
            size++;
        }
    }

    public static void main(String[] argv) {
        LRUCache lc = new LRUCache(3);
        lc.set(1,1);
        lc.set(2,2);
        lc.set(3,3);
        lc.set(4,4);
        lc.get(4);
        lc.get(3);
        lc.get(2);
        lc.get(1);
        lc.set(5,5);
        lc.get(1);
        lc.get(2);
        lc.get(3);
        lc.get(4);
        lc.get(5);


    }


}
