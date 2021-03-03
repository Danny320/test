/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/16 11:33
 */

import java.util.Arrays;

/**
 * 哈希表
 */
public class HashBuck {
    static class Node {
        public int key;
        public int val;
        public Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize;

    public void put(int key,int val) {
        int index = key%array.length;
        for(Node cur = array[index] ; cur != null; cur = cur.next) {
            if(cur.key == key) {
                cur.val = val;
                return;
            }
        }
        Node node = new Node(key,val);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;

        if(loadFactor() > 0.75) {
            resize();//扩容
        }
    }
    public void resize() {
        Node[] newArray = new Node[2*this.array.length];
        for(int i = 0; i < this.array.length; i++) {
            Node cur = this.array[i];
            while(cur != null) {
                Node curNext = cur.next;
                int index = cur.key%newArray.length;
                cur.next = newArray[index];
                newArray[i] = cur;
                cur = curNext;
            }
        }
        this.array = newArray;

    }

    public double loadFactor() {
        return this.usedSize*1.0/this.array.length;
    }

}
