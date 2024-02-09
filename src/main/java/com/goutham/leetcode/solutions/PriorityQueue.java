package com.goutham.leetcode.solutions;

import java.util.Comparator;
import java.util.LinkedList;

import com.goutham.leetcode.utilities.PriorityQueueElement;

public class PriorityQueue {
    

    LinkedList<PriorityQueueElement> queue;
    int capacity;

    public PriorityQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public void enqueue(int value, int priority) {
        if (queue.size() == capacity) {
            // Find the element with the lowest priority to potentially replace it
            int lowestPriorityIndex = -1;
            int lowestPriorityValue = Integer.MAX_VALUE;
            for (int i = 0; i < queue.size(); i++) {
                if (queue.get(i).priority < lowestPriorityValue) {
                    lowestPriorityIndex = i;
                    lowestPriorityValue = queue.get(i).priority;
                }
            }
            // Replace if the new element's priority is higher
            if (priority > lowestPriorityValue) {
                queue.remove(lowestPriorityIndex);
                queue.add(new PriorityQueueElement(value, priority));
            }
        } else {
            queue.add(new PriorityQueueElement(value, priority));
        }
        // Sort by priority, and for same priority, preserve insertion order
       // queue.sort(Comparator.comparingInt((PriorityQueueElement e) -> e.priority).reversed());
       queue.sort(Comparator.comparingInt(e -> -e.priority)); 
    }

    public void dequeue() {
        if (!queue.isEmpty()) {
            queue.removeFirst();
        }
    }

    public void printQueue() {
        System.out.print("Queue: ");
        for (PriorityQueueElement element : queue) {
            System.out.print("(" + element.value + ", " + element.priority + ") ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(3); // Example capacity of 5

        // Example operations
        pq.enqueue(6, 5);
        pq.enqueue(5, 3);
        pq.enqueue(1, -1);
        pq.printQueue();
        pq.dequeue();
        pq.enqueue(-2, 0);
        pq.printQueue(); // Print state of the queue

        pq.dequeue();
        pq.printQueue(); // Print state of the queue after dequeue

        // Adding more elements to test replacement logic
        pq.enqueue(3, 1);
        pq.enqueue(4, 2);
        pq.printQueue(); // Print state of the queue with replacement logic applied
    }
}
