public class Queue <T>{
    private static class Node<T>{
        T data;
        Node<T>next;
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    private Node<T>head;
    private Node<T>tail;
    public Queue(){
        head = null;
        tail = null;
    }
    public synchronized boolean isEmpty(){
        return head==null;
    }
    public synchronized void enqueue(T data){
        Node<T> newNode = new Node<>(data);
        if(tail!=null){
            tail.next = newNode;
        }
        tail=newNode;
        if(head==null){
            head=tail;
        }
        notifyAll();
    }
    public synchronized T dequeue()throws InterruptedException{
        while (isEmpty()){
            wait();
        }
        T data = head.data;
        head = head.next;
        if(head==null){
            tail = null;
        }
        return data;
    }
}
