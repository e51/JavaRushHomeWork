package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("task_02_", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Bob");
            user.setLastName("Brown");
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            user.setBirthDate(new Date(77, 9, 1));

            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println("-----------");
            System.out.println(user.getFirstName() == null ? "user FirstName is null" : user.getFirstName());
            System.out.println(loadedObject.users.get(0).getFirstName() == null ? "loadedObject FirstName is null" : loadedObject.users.get(0).getFirstName());
            System.out.println(user.getLastName() == null ? "user LastName is null" : user.getLastName());
            System.out.println(loadedObject.users.get(0).getLastName() == null ? "loadedObject LastName is null" : loadedObject.users.get(0).getLastName());
            System.out.println(user.getBirthDate() == null ? "user birthday is null" : user.getBirthDate());
            System.out.println(loadedObject.users.get(0).getBirthDate() == null ? "loadedObject birthday is null" : loadedObject.users.get(0).getBirthDate());
            System.out.println(user.getCountry() == null ? "user Country is null" : user.getCountry());
            System.out.println(loadedObject.users.get(0).getCountry() == null ? "loadedObject Country is null" : loadedObject.users.get(0).getCountry());
            System.out.println(user.isMale());
            System.out.println(loadedObject.users.get(0).isMale());


            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);

            writer.println(users.size());
            for (User user : users) {

                writer.println(user.getFirstName() != null ? "yes" + "\r\n" + user.getFirstName() : "no");
                writer.println(user.getLastName() != null ? "yes" + "\r\n" + user.getLastName() : "no");
                writer.println(user.getBirthDate() != null ? "yes" + "\r\n" + user.getBirthDate().getTime() : "no");
                writer.println(user.getCountry() != null ? "yes" + "\r\n" + user.getCountry() : "no");
                writer.println(user.isMale());

//                System.out.println(user.getFirstName());
//                System.out.println(user.getLastName());
//                System.out.println(user.getBirthDate());
//                System.out.println(user.getCountry());
//                System.out.println(user.isMale());

            }

            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            int count = Integer.valueOf(reader.readLine());
            for (int i = 0; i < count; i++) {
                User user = new User();

                user.setFirstName("yes".equals(reader.readLine()) ? reader.readLine() : null);
                user.setLastName("yes".equals(reader.readLine()) ? reader.readLine() : null);
                user.setBirthDate("yes".equals(reader.readLine()) ? new Date(Long.valueOf(reader.readLine())) : null);
                user.setCountry("yes".equals(reader.readLine()) ? User.Country.valueOf(reader.readLine()) : null);
                user.setMale(Boolean.valueOf(reader.readLine()));

//                System.out.println(user.getFirstName());
//                System.out.println(user.getLastName());
//                System.out.println(user.getBirthDate());
//                System.out.println(user.getCountry());
//                System.out.println(user.isMale());

                users.add(user);
            }

        }
    }
}
