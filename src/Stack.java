public class Stack<T> {
    private Node<T> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    // Agrega un elemento a la cima de la pila
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(this.top);
        this.top = newNode;
        this.size++;
    }

    // Saca y devuelve el elemento de la cima
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T data = this.top.getData();
        this.top = this.top.getNext();
        this.size--;
        return data;
    }

    // Observa el elemento de la cima sin sacarlo
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return this.top.getData();
    }
    
    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

}