package week7;
import java.util.*;
public class CircularQueue {
    private int size, front, rear;
    private ArrayList<Integer> queue = new ArrayList<Integer>();

    CircularQueue(int size) {
        this.size = size;
        this.front = this.rear = -1;
    }
    public void enQueue(int data) {
        if((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
            System.out.print("Queue is Full");
        } else if(front == -1) {
            front = 0;
            rear = 0;
            queue.add(rear, data);
        } else if(rear == size - 1 && front != 0) {
            rear = 0;
            queue.set(rear, data);
        } else {
            rear = (rear + 1);

            // Adding a new element if
            if(front <= rear) {
                queue.add(rear, data);
            } else {                // Else updating old value
                queue.set(rear, data);
            }
        }
    }
    public int deQueue() {
        int temp;

        // Condition for empty queue.
        if(front == -1) {
            System.out.print("Queue is Empty");
            return -1;
        }

        temp = queue.get(front);

        // Condition for only one element
        if(front == rear) {
            front = -1;
            rear = -1;
        } else if(front == size - 1) {
            front = 0;
        } else {
            front = front + 1;
        }
        return temp;
    }
    public boolean empty() {
        if(front == -1) {
            return true;
        } else {
            return false;
        }
    }
    public void displayQueue() {
        if(front == -1) {
            System.out.print("Queue is Empty");
            return;
        }
        System.out.print("Elements in the " + "circular queue are: ");

        if(rear >= front) {
            for(int i = front; i <= rear; i++) {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        } else {
            for(int i = front; i < size; i++) {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            for(int i = 0; i <= rear; i++) {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public boolean isFull() {
        if((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
            return true;
        } else {
            return false;
        }
    }
    public int getFront(){
        return queue.get(front);
    }
    public int getRear(){
        return queue.get(rear);
    }
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enQueue(14);
        q.enQueue(22);
        q.enQueue(13);
        q.enQueue(-6);
        q.displayQueue();
        q.deQueue();
        System.out.println("1 element dequeued");
        System.out.println("Is Queue Full   : " + q.isFull());
        System.out.println("Is Queue empty  : " + q.empty());
        System.out.println("Get Front       : " + q.getFront());
        System.out.println("Get Rear        : " + q.getRear());
    }
}
