package com.company;

import java.util.Collections;
import java.util.PriorityQueue;

public class QueueTest {


    public QueueTest() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.add(-1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(4);
        System.out.println(priorityQueue.poll());
    }

    public static void main(String[] args) {
        new QueueTest();
    }
}
