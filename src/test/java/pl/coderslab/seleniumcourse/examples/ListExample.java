package pl.coderslab.seleniumcourse.examples;

import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        String[] strArr = {"ala", "ma", "kota"};
        System.out.println(strArr[0]);
        for (int i=0; i<strArr.length; i++) {
            System.out.println(strArr[i]);
        }
        for (String s : strArr) {
            System.out.println(s);
        }

        List<String> strList = List.of("ala", "ma", "kota");
        strList.add("i");
        strList.add("psa");
        System.out.println(strList.get(0));
        for (int i=0; i<strList.size(); i++) {
            System.out.println(strList.get(i));
        }
        for (String s : strList) {
            System.out.println(s);
        }
    }
}
