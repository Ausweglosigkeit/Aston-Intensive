package org.ural.hw1;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        //ввод некорректного возраста
        person.setAge(-1);
        person.setAge(122);

        System.out.println();
        System.out.println();

        //ввод корректного возраста
        person.setAge(0);
        person.setAge(120);
        person.setAge(12);

        System.out.println();
        System.out.println();

        person.setAge(21);
        System.out.println("Ваш возраст:" + person.getAge());

        System.out.println();
        System.out.println();

        //при помощи рефлексии задаём невалидное значение
        try {
            Field field = person.getClass().getDeclaredField("age");
            field.setAccessible(true);
            field.set(person, 4242);
            //вывод в консоль значения поля age
            System.out.println(field.getInt(person));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        //вывод в консоль значения поля age с помощью геттера
        System.out.println(person.getAge());
    }
}