/**
 * @Author p'c
 * @Date 2020/11/23 15:59
 * @Version 1.0
 */
public class MyLinkedList {
    private Node head;
    private Node last;
    private int size;


    public boolean add(String e) {
        //把节点装到节点对象去
        Node node = new Node(e);
        if(head == null) {
            //链表为空
            this.head = node;
            this.last = node;
        }else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
        return true;
    }
    public boolean add(int index,String e) {

        if(index < 0 || index >size()) {
            throw new IndexOutOfBoundsException("下表越界:"+index);
        }
        Node node = new Node(e);
        if(head == null) {
            //index一定为0
            this.head = node;
            this.last = node;
            size++;

        }else if (index == 0){
            node.next = head;
            head.prev = node;
            head = node;

        }else if(index == size()){
            last.next = node;
            node.prev = last;
            last = node;
        }else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            node.next = prev.next;
            node.prev = prev;
            prev.next = node;
            node.next.prev = node;
        }
        return true;
    }
    public String remove(int index) {
        if(index < 0 || index >= size()) {
            throw  new IndexOutOfBoundsException("下表越界："+index);
        }
        String v = null;
        if(size() == 1) {
            v = head.val;
            head = last = null;
        }else if (index == 0) {
            v = head.val;
            head = head.next;
            head.prev = null;
        }else if (index == size() -1) {
            v = last.val;
            last = last.prev;
            last.next = null;
        }else {
            //找前驱
            Node prev = head;
            for(int i = 0; i < index-1; i++) {
                prev = prev.next;
            }
            v = prev.next.val;
            Node next = prev.next;
            prev.next = next.next;
            next.prev = prev;
        }
        size--;
        return v;
    }
    public boolean remove(String e) {
        Node current = head;
        while (current != null) {
            if(current.val.equals(e)) {
               Node prev = current.prev;
               Node next = current.next;
               if(prev == null) {
                   head = head.next;
               }else {
                   prev.next = next;
               }
               if(next == null) {
                   last = last.prev;
               }else {
                   next.prev = prev;
               }
               size--;
               return true;
            }
        }
        return false;
    }
    public String get(int index) {
        if(index < 0 || index >= size()) {
            throw  new IndexOutOfBoundsException("下表越界："+index);
        }
        Node node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.val;
    }
    public String  set(int index,String e) {
        if(index < 0 || index >= size()) {
            throw  new IndexOutOfBoundsException("下表越界："+index);
        }
        Node node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        String oldVal = node.val;
        node.val = e;
        return oldVal;
    }

    public int size() {return size;}

}