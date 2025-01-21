package com.lotus.jewel.sample.lambda;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MapComputeIfAbsent {

    private static AtomicInteger id = new AtomicInteger(0);

    public static void main(String[] args) {

        Map<String, List<Data>> listMap = new HashMap<>();

        listMap.computeIfAbsent("one", k->{
            return makeNewList();
        });

        listMap.computeIfAbsent("two", k->{
            return makeNewList();
        });

        listMap.computeIfAbsent("three", k->{
            return makeNewList();
        });

        for (Map.Entry<String, List<Data>> m : listMap.entrySet()) {
            String key = m.getKey();
            List<Data> value = m.getValue();
            for(Data d : value) {
                System.out.println(d.getId() + " " + d.getName());
            }

        }

    }

    public static List<Data> makeNewList() {
        int newId = id.incrementAndGet();
        String name = Calendar.getInstance().toString();

        List<Data> result = new ArrayList<>();
        result.add(new Data(newId, name));

        return result;
    }

    public static class Data {
        private long id = 0;

        private String name = "";

        public Data(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
