package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static ru.practicum.dinner.DinnerConstructor.generateDishCombo;

public class Main {
    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        dc = new DinnerConstructor(scanner);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    dc.addNewDish();
                    break;
                case "2":
                    dc.generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nВыберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }
}