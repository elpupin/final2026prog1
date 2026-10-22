public class LinkedList<T> {
    private Node<T> head;
    private int size;
    
    public LinkedList() {

    }
    
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }
    
    
    public T get(int index) {
        // 1. Validar que el índice exista dentro de los límites
        if (index < 0 || index >= size) {
            return null; 
        }
        
        Node<T> current = head;
        // 2. Caminar por los nodos hasta llegar a la posición deseada
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        
        // 3. Devolver el dato guardado en ese nodo
        return current.getData();
    }
    
    
    public T remove(T data) {
        if (head == null) {
            return null; // Lista vacía
        }

        if (head.getData().equals(data)) {
            T removedData = head.getData();
            head = head.getNext();
            size--;
            return removedData;
        }

        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                T removedData = current.getNext().getData();
                current.setNext(current.getNext().getNext());
                size--;
                return removedData;
            }
            current = current.getNext();
        }
        return null; // No se encontró el dato
    }
    
    
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
    
    
    public void clear() {
        head = null;
        size = 0;
    }
    
}