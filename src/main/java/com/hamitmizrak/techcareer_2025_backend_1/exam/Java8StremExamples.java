package com.hamitmizrak.techcareer_2025_backend_1.exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8StremExamples {

    // Array
    public static List<String> arrayToList(){
        String[] cityArray={"malatya","elazığ","bingöl","çorum",  "diyarbakır","malatya"};
        List<String> cityList=new ArrayList<String>();
        cityList=List.of(cityArray);
        return cityList;
    }

    // Collect: Listeye çevirmek
    public static void collectMethod(){
        List<String> original= arrayToList();
        List<String> clone=original.stream().collect(Collectors.toList());
        // for each döngüsü
        for(String temp:clone){
            System.out.print(temp+"\n");
        }
    }

    // ForEach-1: Ekran Çıktısı
    public static void forEach1Method(){
         arrayToList().stream().forEach((temp) -> {
            System.err.println(temp);
        });
    }

    // ForEach-2: Ekran Çıktısı
    public static void forEach2Method(){
        arrayToList().stream().forEach(System.out::println);
    }

    // ForEach: Ekran Çıktısı
    public static void forEach3Method(){
        arrayToList().forEach(System.out::println);
    }

    // Sorted Asc (Küçükten Büyüğe Doğru)
    public static void sortedMethodAsc() {
        //arrayToList().stream().sorted().forEach(System.out::println);
      List<String> sortList=  arrayToList().stream().sorted().collect(Collectors.toList());
      sortList.forEach(System.out::println);
    }

    // Sorted Asc (Büyükten Küçüğe Doğru)
    public static void sortedMethodDesc() {
        //arrayToList().stream().sorted().forEach(System.out::println);
        List<String> sortList=  arrayToList().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        sortList.forEach(System.out::println);
    }

    // Filter: Seçmek
    public static void filterMethod(){
        String search="malatya";
        /*arrayToList().stream().filter((temp)->search.equals(temp)).forEach(System.out::println);*/
        /*arrayToList().stream().filter((temp)->!search.equals(temp)).forEach(System.out::println);*/
       List<String> data = arrayToList().stream().filter((temp)->!search.equals(temp)).collect(Collectors.toList());
       data.forEach(System.out::println);
    }

    public static String buyukharfDonusut(String s){
        return s.toUpperCase().substring(0,3);
    }

    // Map: Elemanlara teker teker uğramak
    public static void mapMethod(){
        //String temp="";
        List<String> data = arrayToList().stream().map((temp)->buyukharfDonusut(temp)).collect(Collectors.toList());
        data.forEach(System.out::println);
    }

    // Distinct:  Tekrarsız verileri sağlamak
    public static void distinctMethod(){
        List<String> data = arrayToList()
                .stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        data.forEach(System.out::println);
    }

    // Limit: Verilerden istediğimiz kadar veri almak
    public static void limitMethod(){
        List<String> dataList = arrayToList();
        dataList.stream().limit(3).forEach(System.out::println);
    }


    public static void main(String[] args) {
        /*collectMethod();*/
        /*forEachMethod();*/
        /*forEach2Method();*/
        /*forEach3Method();*/
        /*sortedMethodAsc();*/
        /*sortedMethodDesc();*/
        /*filterMethod();*/
        /*mapMethod();*/
        /*distinctMethod();*/
        limitMethod();
    }

}
