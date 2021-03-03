import java.util.Arrays;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/11 11:23
 */
public class MyCircularQueue {
    public int[] elem;
    public int usedSize;
    public MyCircularQueue() {
        this.elem = new int[10];
    }
    public int front;//头
    public int rear;//尾巴
    public boolean offer(int val) {
        if(full()) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        this.elem[this.rear] = val;
        this.rear = (this.rear+1)%this.elem.length;
        this.usedSize++;
        return true;
    }
    public int poll() {
       if(isEmpty()) {
           throw new RuntimeException("队列为空");
       }
       this.front = (this.front+1)%this.elem.length;
       return this.elem[this.front];
    }
    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return this.elem[(this.front+1)%this.elem.length];
    }
    public int size() {
        return this.usedSize;
    }
    public boolean full() {
        if((this.rear+1)%this.elem.length == this.front) {
            return true;
        }else {
            return false;
        }
    }
    public boolean isEmpty() {
        return this.rear == this.front;
    }

    //返回队尾元素
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        int index = this.rear == 0 ? this.elem.length-1:this.rear-1;
        return this.elem[index];
    }
}
