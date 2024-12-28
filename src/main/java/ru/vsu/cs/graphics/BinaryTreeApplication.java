package ru.vsu.cs.graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.vsu.cs.logic.BinaryTree;

public class BinaryTreeApplication extends Application {
    private BinaryTree<Integer> binaryTree = new BinaryTree<>();

    @Override
    public void start(Stage primaryStage) {
        // Создаем корневой макет
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 10;");

        // Поле ввода
        TextField inputField = new TextField();
        inputField.setPromptText("Введите целое число");

        // Кнопки для операций
        Button insertButton = new Button("Добавить");
        Button deleteButton = new Button("Удалить");
        Button findButton = new Button("Найти");

        // Результат выполнения операций
        Label resultLabel = new Label();

        // Область для отображения дерева
        TextArea treeView = new TextArea();
        treeView.setEditable(false); // Только для чтения
        treeView.setPrefHeight(200);
        updateTreeView(treeView);

        // Обработчики событий
        insertButton.setOnAction(e -> {
            try {
                int value = Integer.parseInt(inputField.getText());
                binaryTree.insert(value);
                resultLabel.setText("Число " + value + " добавлено в дерево.");
                updateTreeView(treeView);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Пожалуйста, введите допустимое целое число.");
            }
        });

        deleteButton.setOnAction(e -> {
            try {
                int value = Integer.parseInt(inputField.getText());
                binaryTree.delete(value);
                resultLabel.setText("Число " + value + " удалено из дерева (если существовало).");
                updateTreeView(treeView);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Пожалуйста, введите допустимое целое число.");
            }
        });

        findButton.setOnAction(e -> {
            try {
                int value = Integer.parseInt(inputField.getText());
                BinaryTree.Node<Integer> node = binaryTree.findNode(value);
                if (node != null) {
                    resultLabel.setText("Число " + value + " найдено в дереве.");
                } else {
                    resultLabel.setText("Число " + value + " не найдено в дереве.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Пожалуйста, введите допустимое целое число.");
            }
        });

        // Компоновка кнопок
        HBox buttonBox = new HBox(10, insertButton, deleteButton, findButton);

        // Добавление элементов в корневой макет
        root.getChildren().addAll(inputField, buttonBox, resultLabel, treeView);

        // Настройка сцены и отображение
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Binary Tree App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateTreeView(TextArea treeView) {
        // Обновление отображения дерева
        treeView.setText(binaryTree.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
