public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    // Constructor
    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    //Encola
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    // Desencola 
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T data = front.getData();
        front = front.getNext();
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return data;
    }

    // Observa el primer elemento
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return front.getData();
    }

    // Verifica si esta vacio
    public boolean isEmpty() {
        return size == 0;
    }

    // Devuelve el tamaño
    public int getSize() {
        return size;
    }
}
