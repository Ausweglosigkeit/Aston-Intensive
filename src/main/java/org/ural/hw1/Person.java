package org.ural.hw1;

public class Person {
    private int age;

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            System.out.println("Пожалуйста, введите возраст от 0 до 120");
        } else {
            this.age = age;
            System.out.println("Ваш возраст записан.");
        }
    }

    public int getAge() {
        return age;
    }
}
