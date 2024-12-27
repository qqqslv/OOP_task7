package ru.vsu.cs.logic;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(6);
        tree.insert(8);
        tree.insert(5);
        tree.insert(2);
        tree.insert(9);
        tree.insert(7);
        tree.insert(4);
        tree.insert(10);
        tree.insert(3);
        tree.insert(1);
        tree.insert(15);
        tree.insert(1);
        tree.insert(12);

        tree.printRoot();

        List<Integer> sortedElements = tree.inOrderTraversal();
        System.out.println(sortedElements);

        tree.delete(7);
        sortedElements = tree.inOrderTraversal();
        System.out.println(sortedElements);

        tree.delete(6);
        sortedElements = tree.inOrderTraversal();
        System.out.println(sortedElements);
        tree.printRoot();

        tree.delete(8);
        sortedElements = tree.inOrderTraversal();
        System.out.println(sortedElements);
        tree.printRoot();

        tree.delete(9);
        sortedElements = tree.inOrderTraversal();
        System.out.println(sortedElements);
        tree.printRoot();

        tree.delete(10);
        sortedElements = tree.inOrderTraversal();
        System.out.println(sortedElements);
        tree.printRoot();

        tree.delete(12);
        sortedElements = tree.inOrderTraversal();
        System.out.println(sortedElements);
        tree.printRoot();

        tree.delete(15);
        sortedElements = tree.inOrderTraversal();
        System.out.println(sortedElements);
        tree.printRoot();

        tree.delete(5);
        sortedElements = tree.inOrderTraversal();
        System.out.println(sortedElements);
        tree.printRoot();

        tree.delete(2);
        sortedElements = tree.inOrderTraversal();
        System.out.println(sortedElements);
        tree.printRoot();

        tree.delete(3);
        sortedElements = tree.inOrderTraversal();
        System.out.println(sortedElements);
        tree.printRoot();
    }
}
