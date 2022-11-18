
/**
 * //Sourabh Tantuway, Shivam Gautam
 * //SXT200011, SXG200011
 * //Section: 001

 PROBLEM STATEMENT: [Doubly Linked List, HashMap]

 Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 Implement the LRUCache class:
 LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 int get(int key) Return the value of the key if the key exists, otherwise return -1.
 void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 The functions get and put must each run in O(1) average time complexity.

 link: https://leetcode.com/problems/lru-cache/description/
 **/

package Q23;
import Q1.IntersectNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node{

        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }

    }
    HashMap<Integer, Node> map;
    int capacity, count;
    Node head, tail;

    public LRUCache(int capacity) {
        map  = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
        this.capacity =  capacity;
    }

    public void deleteNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHome(Node node){
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public int get(int key) {
        if(map.get(key) != null){
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHome(node);
            return result;
        }

        return -1;
    }

    public void put(int key, int value) {
        if(map.get(key) != null){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHome(node);
        }else{
            Node node = new Node(key, value);
            map.put(key, node);
            if(count < capacity){
                count++;
                addToHome(node);
            }else{
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHome(node);
            }

        }
    }

    public void print(){
        System.out.print("Cache now is: ");
        for(Map.Entry<Integer, Node> entry : map.entrySet()){
            System.out.print("[ " +entry.getValue().value + "]");
        }
        System.out.println(" ");
    }
    public static void main(String[] args){

        LRUCache lRUCache = new LRUCache(2);
        System.out.println("putting [1]" );
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.print();
        System.out.println("putting [2]" );
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.print();
        System.out.println("getting key 1, returns " + lRUCache.get(1) );  // returns 1
        System.out.println("putting [3]" );
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.print();
        System.out.println("getting key 2, returns " + lRUCache.get(2) );     // returns -1 (not found)
        System.out.println("putting [4]" );
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.print();
        System.out.println("getting key 1, returns " + lRUCache.get(1) );    // return -1 (not found)
        lRUCache.print();
        System.out.println("getting key 3, returns " + lRUCache.get(3) );   // return 3

        lRUCache.get(4);    // return 4

    }
}


