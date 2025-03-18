package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class DinnerConstructor {
    static HashMap<String, ArrayList<String>> dishes;
    static Scanner sc;
    static Random rd;

    public DinnerConstructor(Scanner scanner) {
        sc = scanner;
        dishes = new HashMap<>();
        rd = new Random();
    }

    public static boolean checkType(String key) {
        return dishes.containsKey(key);
    }

    public static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = sc.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = sc.nextLine();

        if (checkType(dishType)) {
            dishes.get(dishType).add(dishName);
        } else {
            ArrayList<String> dishNames = new ArrayList<>();
            dishNames.add(dishName);
            dishes.put(dishType, dishNames);
        }
    }

    public static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = sc.nextInt();
        sc.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

        ArrayList<String> necessaryDishes = new ArrayList<>();

        while (true) {
            String necessaryDish = sc.nextLine();

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
                ArrayList<String> dishesInCategory = dishes.get(category);

                int index = rd.nextInt(necessaryDishes.size());
                combo.add(dishesInCategory.get(index));
            }
            System.out.println(combo);
            counter++;
        }
    }
}