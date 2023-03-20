package org.example;
/** Пусть дан LinkedList с несколькими элементами.
 * Реализуйте метод, который вернет “перевернутый” список.
 */

import java.util.LinkedList;
import java.util.Random;
import java.util.List;

public class Task02 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> randomLinkedList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            randomLinkedList.add(random.nextInt(1, 100));
        }

        System.out.println("Дан LinkedList: " + randomLinkedList.toString());

        List<Integer> RevertLinkedList = new LinkedList<>();

        for (int i = randomLinkedList.size() - 1; i >= 0; i--) {
            RevertLinkedList.add(randomLinkedList.get(i));
        }

        System.out.println("Перевёрнутый LinkedList: " + RevertLinkedList.toString());
    }
}