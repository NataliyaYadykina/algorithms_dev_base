package homework.hw2;

class dList {
    Node head;
    Node tail;

    class Node {
        int value;
        Node next;
        Node prev;
    }

    void push_front(int value){
        Node node = new Node();
        node.value = value;

        if(head == null){
            tail = node;
        }else {
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    public void revert() {
        Node cur = head;

        while (cur != null) {
            Node next = cur.next;
            Node prev = cur.prev;
            cur.next = prev;
            cur.prev = next;
            if (prev == null) {
                tail = cur;
            }
            if (next == null) {
                head = cur;
            }
            cur = next;
        }

    }

    void print(){
        Node cur = head;
        while(cur != null){
            System.out.println(cur.value);
            cur = cur.next;
        }
    }

}
public class Main {

    public static void main(String[] args) {

        dList list = new dList();
        for(int i=0; i<=10; i++) {
            list.push_front(i);
        }

        list.print();
        System.out.println();

        list.revert();

        list.print();

    }

}
