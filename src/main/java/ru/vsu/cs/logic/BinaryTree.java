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

    private void delete(T value) {
        Node<T> current = root;
        Node<T> parent = root;
        boolean isLeft = true;

        while (value.compareTo(current.value) != 0) {
            parent = current;
            if (value.compareTo(current.value) < 0) {
                isLeft = true;
                current = current.left;
            } else {
                isLeft = false;
                current = current.right;
            }
            if (current == null) {
                return;
            }
        }

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeft) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeft) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {
            Node<T> heir = findHeir(current);
            if (current == root) {
                root = heir;
            } else if (isLeft) {
                parent.left = heir;
            } else {
                parent.right = heir;
            }
        }
    }

    private Node<T> findHeir(Node<T> node) {
        return node; //not ready yet..((
    }
}
