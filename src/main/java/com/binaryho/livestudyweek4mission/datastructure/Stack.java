package com.binaryho.livestudyweek4mission.datastructure;

public class Stack<T> {

    private ListNode topNode;
    private int size;

    Stack() {
        topNode = new ListNode(null, null, null);
        size = 0;
    }

    public void top() {
        if (size == 0) {
            System.out.println("[ERROR] : stack is empty");
            return;
        }
        System.out.println("top data is " + topNode.getNext().getData());
    }

    public void push(T data) {
        ListNode newNode = new ListNode(data, topNode.getNext(), null);
        topNode = new ListNode(topNode.getData(), newNode, null);
        size++;
    }

    public void pop() {
        if (size ==0) {
            System.out.println("[ERROR] : stack is empty");
            return;
        }

        if (size == 1) {
            topNode = new ListNode(topNode.getData(), null, null);
        } else {
            topNode = new ListNode(
                topNode.getData(), topNode.getNext().getNext(), null);
        }
        size--;
    }
}
