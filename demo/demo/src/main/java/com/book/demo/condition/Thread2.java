package com.book.demo.condition;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@org.springframework.stereotype.Service
public class Thread2 extends Thread {

    private List<ConcurrentHashMap<String, String>> list = new ArrayList<>();

    private ConcurrentHashMap<String, String> cm;

    public void addCm(ConcurrentHashMap<String, String> cm) {
        list.add(cm);
    }

    @Override
    public void run() {
        for (ConcurrentHashMap cm : list) {
            System.out.println(cm.get("num") + "---" + Thread.currentThread().getName());
        }
    }
}
