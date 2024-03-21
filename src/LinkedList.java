import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class LinkedList<T extends Comparable> {
    private int nodeNumber;
    private Node<T> head;
    private Node<T> iterator;

    public Node<T> createNode(T val) {
        return new Node<T>(val);
    }

    public void insertFromFile(String txtName) throws IOException {
        for (String i : FileManager.readFile(txtName)) {
            insertToEnd((T) i);
        }
    }

    public void searchFromFile(String txtName,boolean putValuesToStartThatAlreadyExists) throws IOException {
        Instant start = Instant.now();
        MemoryManager memoryManager = new MemoryManager();
        for (String i : FileManager.readFile(txtName)) {
            checkIfTheValueExists((T) i, memoryManager,putValuesToStartThatAlreadyExists);
        }
        System.out.println("total memory access number: " + memoryManager.getMemoryAccessNumber());
        System.out.println("avarage memory access number: " + memoryManager.getAvarageMemoryAccess(nodeNumber));
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("time passed: " + timeElapsed.toNanos());
    }

    public boolean checkIfTheValueExists(T val, MemoryManager memoryManager,boolean putTheValueToStart) {
        Node<T> iterator = head;
        boolean isItExists = false;
        while (iterator != null) {
            memoryManager.updateMemory();
            if (iterator.value.compareTo(val) == 0) {
                if(putTheValueToStart){
                    putTheValueToStart(iterator,memoryManager);
                }
                isItExists = true;
                break;
            }
            iterator = iterator.next;
            memoryManager.updateMemory();
        }
        return isItExists;
    }

    public boolean checkIfTheValueExists(T val) {
        Node<T> iterator = head;
        boolean isItExists = false;
        while (iterator != null) {
            if (iterator.value.compareTo(val) == 0) {
                isItExists = true;
                break;
            }
            iterator = iterator.next;
        }
        return isItExists;
    }

    public void putTheValueToStart(Node<T> node, MemoryManager memoryManager) {
        Node<T> iterator = head;
        if (node == head) {
        }
        else {
            while (iterator.next != node) {
                iterator = iterator.next;
                memoryManager.updateMemory();
            }
            iterator.next = node.next;
            memoryManager.updateMemory();
            node.next = head;
            head = node;
        }
    }

    public void insertToEnd(T val) {
        Node<T> newNode = createNode(val);
        if (head == null) {
            nodeNumber++;
            head = newNode;
        } else if (checkIfTheValueExists(val)) {
        } else {
            nodeNumber++;
            Node<T> iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
        }
    }

    public void display() {
        Node<T> iterator = head;
        while (iterator != null) {
            System.out.print(iterator + "->");
            iterator = iterator.next;
        }
        System.out.println();

    }

    public int getNodeNumber() {
        return nodeNumber;
    }
}
