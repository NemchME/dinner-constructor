package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static Random rd;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);
        rd = new Random();

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    public static boolean checkType(String key) {
        return dc.dishes.containsKey(key);
    }

    private static void printMenu() {
        System.out.println("\nВыберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        if (checkType(dishType)) {
            dc.dishes.get(dishType).add(dishName);
        } else {
            ArrayList<String> dishNames = new ArrayList<>();
            dishNames.add(dishName);
            dc.dishes.put(dishType, dishNames);
        }
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

        ArrayList<String> necessaryDishes = new ArrayList<>();

        while (true) {
            String necessaryDish = scanner.nextLine();

            if (necessaryDish.isEmpty()) {
                break;
            }
            if (checkType(necessaryDish)) {
                necessaryDishes.add(necessaryDish);
            } else {
                System.out.println("Несуществующий тип блюда!");
            }
        }

        int counter = 1;
        while (numberOfCombos != counter) {
            System.out.println("Комбо №" + counter);
            ArrayList<String> combo = new ArrayList<>();

            for (int i = 0; i < necessaryDishes.size(); i++) {
                String category = necessaryDishes.get(i);
                ArrayList<String> dishesInCategory = dc.dishes.get(category);

                int index = rd.nextInt(necessaryDishes.size());
                combo.add(dishesInCategory.get(index));
            }
            System.out.println(combo);
            counter++;
        }
    }
}
