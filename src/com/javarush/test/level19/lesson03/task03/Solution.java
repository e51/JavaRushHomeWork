package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

//    public static void main(String[] args) {
//        IncomeData id = new IncomeData() {
//            @Override
//            public String getCountryCode() {
//                return "UA";
//            }
//
//            @Override
//            public String getCompany() {
//                return "JavaRush Ltd.";
//            }
//
//            @Override
//            public String getContactFirstName() {
//                return "Ivan";
//            }
//
//            @Override
//            public String getContactLastName() {
//                return "Ivanov";
//            }
//
//            @Override
//            public int getCountryPhoneCode() {
//                return 38;
//            }
//
//            @Override
//            public int getPhoneNumber() {
//                return 501234567;
//            }
//        };
//
//        IncomeDataAdapter adapter = new IncomeDataAdapter(id);
//
//        System.out.println(id.getCountryCode());
//
//        System.out.println(adapter.getCompanyName());
//        System.out.println(adapter.getName());
//        System.out.println(adapter.getPhoneNumber());
//        System.out.println(adapter.getCountryName());
//
////        for (Map.Entry<String, String> pair : countries.entrySet()) {
////            System.out.println(pair.getKey() + " : " + pair.getValue());
////        }
//
//    }


    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData component;

        public IncomeDataAdapter(IncomeData component) {
            this.component = component;
        }

        @Override
        public String getName() {
            return component.getContactLastName() + ", " + component.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String str = "";

            for (int i = String.valueOf(component.getPhoneNumber()).length(); i < 10; i++) {
                str = str + "0";
            }
            str = str + component.getPhoneNumber();

            return "+" + component.getCountryPhoneCode() + "(" + str.substring(0, 3) + ")" + str.substring(3, 6) + "-" + str.substring(6, 8) + "-" + str.substring(8, 10);
        }

        @Override
        public String getCompanyName() {
            return component.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(component.getCountryCode());
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }

}