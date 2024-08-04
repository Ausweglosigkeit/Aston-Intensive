package org.ural.hw6;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Sirius", "Black", "male", 38);

        File data = new File("D:\\Aston\\Aston-Intensive\\src\\main\\java\\org\\ural\\hw6\\File.txt");

        try (FileOutputStream outputStream = new FileOutputStream(data)) {
            String[] dataOfPerson = person1.getDataOfPerson();
            for (String t : dataOfPerson) {
                byte[] buffer = t.getBytes();
                outputStream.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Person person2;
        String name;
        String surname;
        String sex;
        int age;

        try (FileInputStream inputStream = new FileInputStream(data);
             Reader reader = new InputStreamReader(inputStream)) {

            int i = 0;
            int bytesRead;
            boolean bFlag = false;
            byte[] buffer = {};
            List<String> pers = new ArrayList<>();
            while ((bytesRead = reader.read()) != -1) {
                if (bytesRead == 10) {
                    int j = 0;
                    for (; j < 6; ++j) {
                        if (buffer[j] == 0) {
                            break;
                        }
                    }
                    pers.add(new String(buffer, 0, j));
                    bFlag = false;
                }

                if (bFlag) {
                    buffer[i] = (byte) bytesRead;
                    i++;
                }

                if (bytesRead == 32) {
                    buffer = new byte[6];
                    i = 0;
                    bFlag = true;
                }

            }
            name = pers.get(0);
            surname = pers.get(1);
            sex = pers.get(2);
            age = Integer.parseInt(pers.get(3));
            // наполняем данными из файла новую персону
            person2 = new Person(name, surname, sex, age);
            System.out.println(person2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
