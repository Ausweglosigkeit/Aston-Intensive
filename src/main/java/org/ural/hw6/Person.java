package org.ural.hw6;


public class Person {
    String name;
    String surname;
    String sex;
    int age;

    public Person(String name, String surname, String sex, int age) {
        this.age = age;
        this.sex = sex;
        this.surname = surname;
        this.name = name;
    }

    public String[] getDataOfPerson() {
        return new String[]{"Name: " + name + "\n", "Surname: " + surname + "\n", "Sex: " + sex + "\n", "Age: " + age + "\n"};
    }

    @Override
    public String toString() {
        return name + "\n" + surname + "\n" + sex + "\n" + age;
    }
}