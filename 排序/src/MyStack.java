import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：LD
 * @description：TODO
 * @date ：2021/1/11 10:12
 */
public class MyStack {
//    public int[] elem;
//    public int top = 0;
//
//    public MyStack() {
//        this.elem = new int[10];
//
//    }
//    public void push(int val) {
//        if(full()) {
//            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
//        }
//        this.elem[top++] = val;
//    }
//    public boolean empty() {
//       return this.top == 0;
//    }
//    public boolean full() {
//      return this.top == this.elem.length;
//    }
//    public int pop() {
//        if(empty()) {
//            throw new RuntimeException("栈空");
//        }
//        int data = this.elem[top-1];
//        this.top--;
//        return data;
//    }
//    public int peek() {
//        if(empty()) {
//            throw new RuntimeException("栈空");
//        }else {
//            return elem[top-1];
//        }
//    }
//    public int size() {
//        return this.top;
//    }
public MyStack() {
}
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    /** Push element x onto stack. */
    public void push(int x) {
        if(queue1.isEmpty()) {
            queue1.offer(x);
        }else {
            queue2.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!queue1.isEmpty()) {
            for(int i = 0; i < queue1.size()-1; i++) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }else {
            for(int i = 0; i < queue2.size()-1; i++) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }

    }

    /** Get the top element. */
    public int top() {
        if(!queue1.isEmpty()) {
            for(int i = 0; i < queue1.size()-1; i++) {
                queue2.offer(queue1.poll());
            }
            int ret = queue1.poll();
            queue2.offer(ret);
            return ret;
        }else {
            for(int i = 0; i < queue2.size()-1; i++) {
                queue1.offer(queue2.poll());
            }
            int ret = queue2.poll();
            queue1.offer(ret);
            return ret;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }
}
