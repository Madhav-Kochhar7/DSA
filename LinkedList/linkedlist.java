package LinkedList;
public class linkedlist {

    private Node head;
    private Node tail;
    private int size;

    linkedlist(){
        this.size = 0;
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if(tail == null){  // tail == null i.e LL is empty, this is the first element being added
            tail = head;
        }

        size+=1;
        }

    public void insertLast(int value){
        if(tail == null){  // linkedlist is empty
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;

    }

    public void insert(int value, int idx){
        if(idx == 0 ) {
            insertFirst(value);
            return;
        }

        if(idx == size) {
            insertLast(value);
            return;
        }

        Node temp = head;
        for(int i = 1; i < idx ; i++){
            temp = temp.next;
        }

        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;

    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public Node get(int index){
        Node node = head;
        for(int i = 0; i< index ; i++){
            node = node.next;
        }
        return node;
    }

    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }

        Node secondLast = get(size-2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return deleteLast();
        }

        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    class Node{         // the box
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        linkedlist list = new linkedlist();

        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertLast(99);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertLast(99);
        list.insert(7, 2);
        System.out.println(list.deleteFirst());
        System.out.println(list.deleteLast());
        System.out.println(list.delete(2));

        list.display();
    }
    
}