package org.example;
/**  Реализовать консольное приложение, которое:
 Принимает от пользователя и “запоминает” строки.
 Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
 Если введено revert, удаляет предыдущую введенную строку из памяти.
 *
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        LinkedList<String> inputWordsList = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Перед использованием ознакомтесь с командами!\n Команды: \n print - переворачивает список.\n stop - остановка. " +
                "\n revert - удаляет предпоследний элемент из списка. \n all - показывает весь список");

        while (true) {
            System.out.println();
            System.out.println("Введите строку: ");
            String inputString = in.nextLine();

            if (inputString.isBlank()) {
                System.out.println("Строка не должна быть пустой");
                continue;
            }
            if (inputString.equalsIgnoreCase("stop")) {
                break;
            }
            if (inputString.equalsIgnoreCase("print")) {
                inputWordsList = reverseLinkedList(inputWordsList);
                System.out.print("\nElements after reversing: " + inputWordsList);
                break;
            }
            if (inputString.equalsIgnoreCase("revert")) {

                inputWordsList.remove(inputWordsList.size() - 2);
                System.out.print("\nLinkedList удален предыдущий элемент: " + inputWordsList);
                break;

            }

            if (inputString.equalsIgnoreCase("all")) {
                printAllNotNullValues(inputWordsList);
                continue;
            }

            String[] parts = inputString.split(" ");

            String word = parts[0];
            int num = 0;

            if (word.equalsIgnoreCase("print")) {
                System.out.printf("Под номером %d находится слово: %s%n", num, inputWordsList.get(num - 1));
                    inputWordsList.remove(num - 1);


            } else {
                int nullCount = num - inputWordsList.size() - 1;
                for (int i = 0; i < nullCount; i++) {
                    inputWordsList.add(null);
                }
                inputWordsList.add(word);

            }

        }

    }

    private static LinkedList<String> reverseLinkedList(LinkedList<String> llist) {
        LinkedList<String> revLinkedList = new LinkedList<String>();
        for (int i = llist.size() - 1; i >= 0; i--) {

            revLinkedList.add(llist.get(i));
        }

        return revLinkedList;
    }

    private static void printAllNotNullValues(LinkedList<String> inputWordsList) {
        for (int i = 0; i < inputWordsList.size(); i++) {
            if (inputWordsList.get(i) != null) {
                System.out.printf("%d) %s%n", i + 1, inputWordsList.get(i));
            }
        }
    }
}