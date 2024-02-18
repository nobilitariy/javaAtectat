package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class App 
{
    private static   Map<String, ArrayList<Integer>> contact = new HashMap<>();
    public static void main( String[] args ){
        meny();
    }
    private static void meny(){
        System.out.println( "КОНТАКТНАЯ КНИГА:" );
        System.out.println("Выберете действие:");
        System.out.println("1. Добавить контакт");
        System.out.println("2. Удалить контакт");
        System.out.println("3. Изменить контакт");
        System.out.println("4. Просмотреть контакт(-ы)");
        System.out.println("Выберите действие(укажите цифру): ");
        Scanner scanner = new Scanner(System.in);
        Integer deistvie = scanner.nextInt();
        switch (deistvie) {
            case 1:
                Add(contact);
                break;
            case 2: 
                delite(contact);
            case 3:
                ismenit(contact);
            case 4:
                vivod(contact);
        }
    }
    private static void Add(Map<String, ArrayList<Integer>> contact){
        System.out.println("Введите имя контакта: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (!contact.containsKey(name)) {
            System.out.println("Введите номер телефона: ");
            Integer number = scanner.nextInt();
            ArrayList<Integer> numberList = new ArrayList<>();
            numberList.add(number);
            contact.put(name, numberList);
            System.err.println("Контакт добавлен!");
        }
        else{
            System.out.println("Контакт с таким именем существует.");
        }
        System.out.println("Нажмите любую цифру для продолжения: ");
        Integer userNum = scanner.nextInt();
        meny();
    }
    private static void ismenit(Map<String, ArrayList<Integer>> contact){
        System.out.println("Введите имя контакта который будете изменять(дополнять): ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (contact.containsKey(name)) {
            System.out.println("1. Изменить имя");
            System.out.println("2. Дополнить контакт");
            Integer number = scanner.nextInt();
            scanner.nextLine();
            if (number == 1) {
                System.out.println("Введите новое имя контакта: ");
                String newName = scanner.nextLine();
                contact.put(newName, contact.get(name));
                contact.remove(name);
                System.out.println("Имя контакта изменено!");
            }
            else{
                System.out.println("Введите новый номер контакта: ");
                Integer newNumber = scanner.nextInt();
                contact.get(name).add(newNumber);
                System.out.println("Контакт изменен(дополнен)");
            }
            
        }else{
            System.out.println("Контакт с таким именем не существует.");
        }
        System.out.println("Нажмите любую цифру для продолжения: ");
        Integer userNum = scanner.nextInt();
        meny();
    }
    private static void delite(Map<String, ArrayList<Integer>> contact){
        System.out.println("Введите имя контакта для удаления: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (contact.containsKey(name)) {
            System.out.println("Контакт " + name + " - " + contact.get(name)+ ", удален!");
            contact.remove(name);
        } else {
            System.out.println("Ключ не найден");
        }
        System.out.println("Нажмите любую цифру для продолжения: ");
        Integer userNum = scanner.nextInt();
        meny();
    }
    private static void vivod(Map<String, ArrayList<Integer>> contact){
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<String, ArrayList<Integer>> elem : contact.entrySet()) {
            set.add(elem.getValue().size());
        } 
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        for (Integer size : list){
            for (Map.Entry<String, ArrayList<Integer>> elem : contact.entrySet()) {
                if (size == elem.getValue().size()) {
                    System.out.println(elem);
                }
            }   
        }
        System.out.println("Нажмите любую цифру для продолжения: ");
        Integer userNum = scanner.nextInt();
        meny();
    }
}

