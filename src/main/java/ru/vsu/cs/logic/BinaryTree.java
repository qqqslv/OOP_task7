package ru.vsu.cs.logic;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree <T extends Comparable<T>> {
    private Node<T> root;
    public BinaryTree() {
        root = null;
    }
    private static class Node<T> {
        T value;
        Node<T> right;
        Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }

    public void insert(T value) {
        Node<T> newNode = new Node<>(value);
        if (root == null) {
            root = newNode;
            return;
        }

        Node<T> current = root;
        Node<T> parent;
        while (true) {
            parent = current;
            if (value.compareTo(current.value) == 0) {
                return;
            } else if (value.compareTo(current.value) < 0) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public void delete(T value) {
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
        Node<T> parent = node;
        Node<T> heir = node;
        Node<T> current = node.right;
        while (current != null) {
            parent = heir;
            heir = current;
            current = current.left;
        }
        if (heir != node.right) {
            parent.left = heir.right;
            heir.right = node.right;
        }
        heir.left = node.left;
        return heir;
    }

    public List<T> inOrderTraversal() {
        List<T> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(Node<T> node, List<T> result) {
        if (node != null) {
            inOrderTraversal(node.left, result);  // Рекурсивный вызов для левого поддерева
            result.add(node.value);              // Добавление значения узла в результат
            inOrderTraversal(node.right, result); // Рекурсивный вызов для правого поддерева
        }
    }
    public void printRoot() {
        System.out.println(root.value);
    }
}
