package com.binaryho.livestudyweek4mission.datastructure;

public class Queue<T> {

    private ListNode head;
    private ListNode tail;
    private int size;

    Queue() {
        head = new ListNode(null, tail, null);
        tail = new ListNode(null, null, null);
        head.setNext(tail);
        tail.setPrev(head);

        size = 0;
    }

    public void front() {
        if (size == 0) {
            System.out.println("[ERROR] : Queue is empty");
            return;
        }
        System.out.println("front data is " + head.getNext().getData());
    }

    public void push(T data) {
        ListNode newNode = new ListNode(data, head.getNext(), head);
        head = new ListNode(head.getData(), newNode, null);
        size++;
    }

    public void pop() {
        if (size ==0) {
            System.out.println("[ERROR] : queue is empty");
            return;
        }

        tail.getPrev().getPrev().setNext(tail);
        tail.setPrev(tail.getPrev().getPrev());
        size--;
    }
}
