import com.sun.corba.se.pept.transport.ListenerThread;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/11 10:56
 */
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
public class MyQueue {
    public Node front;//头
    public Node rear;//尾巴
    int usedSize;

    public boolean offer(int val) {
        Node node = new Node(val);
        if(this.rear == null ) {
            this.front = node;
            this.rear = node;
        }else {
            this.rear.next = node;
            this.rear = node;
        }
        this.usedSize++;
        return true;
    }
    public int poll() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int data = this.front.data;
        this.front = this.front.next;
        this.usedSize--;
        return data;
    }
    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int data = this.front.data;
        return data;
    }
    public int size() {
        return this.usedSize;
    }
    public boolean isEmpty() {
        return this.usedSize == 0;
    }



}
