package com.yedam.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.bookApp.Book;

public class MapExe {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(100, "홍길동");
        map.put(101, "김민수");
        map.put(102, "김혁수");
        
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        
        map.remove(101);
        Set<Entry<Integer, String>> mapentry = map.entrySet();
        for (Entry<Integer, String> entry : mapentry) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        
//        boolean run = true;
//        if (run)
//            return;

        Map<String, Book> books = new HashMap<>();
        books.put("B001", new Book("JAVA", "신용권", "한빛", 20000));
        books.put("B002", new Book("Javascript", "김자스", "한빛", 25000));
        books.put("B003", new Book("HTML/CSS", "이에시", "한빛", 28000));

        // Book result = books.get("B001");

        // key set 반환
        Set<String> keyset = books.keySet();
        for (String key : keyset) {
            System.out.println("key: " + key + ", value: " + books.get(key).showList());
        }
        
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        // key : value Entry 반환
        Set<Entry<String, Book>> entryset = books.entrySet();
        for (Entry<String, Book> entry : entryset) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue().showList());
        }

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // 자바 객체 -> JSON 형식 문자열
        String json = gson.toJson(books);
        System.out.println(json);
    }
}
