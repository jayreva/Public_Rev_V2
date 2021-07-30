package demos;

import java.util.PriorityQueue;

public class demo106 {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Mark");
        queue.add("Paul");
        queue.add("Stacy");
        queue.add("Watson");
        queue.add("John");

        for(String name: queue){
            System.out.println(name);
        }

        //add()
        //remove()
        //poll() retrieves and removes element at the head
        //element() retrieves the element at the head
        //peek()

        System.out.println("head:" + queue.element());
        System.out.println("head:" + queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.poll());

        for(String name: queue){
            System.out.println(name);
        }

    }
}
