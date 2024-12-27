package ru.vsu.cs.logic;

public class BinaryTree <T extends Comparable<T>> {
    private Node<T> root;
    private static class Node<T> {
        T value;
        Node<T> right;
        Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    private void insert(T value) {
        Node<T> newNode = new Node<>(value);
        if (root == null) {
            root = newNode;
            return;
        }

        Node<T> current = root;
        while (true) {
            if (value.compareTo(current.value) == 0) {
                return;
            } else if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else if (value.compareTo(current.value) > 0) {
                current = current.right;
            }
            if (current == null) {
                current = newNode;
                return;
            }
        }
    }
}
