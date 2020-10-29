package com.designing.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ScanTest implements Iterable<String> {
    private ArrayList<String> appleStore = new ArrayList<>();
    public ScanTest(){
        Collections.addAll(appleStore, "Sweet", "Sour", "Bitter", "litter Sweet", "litter Sour", "litter Bitter");
        System.out.println(appleStore);
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            private int i = 0;

            @Override
            public boolean hasNext() {
                if (i < appleStore.size()){
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public String next() {
                return appleStore.get(i++);
            }

            @Override
            public void remove() {
                System.out.println("not defined!");
            }
        };
    }

    public Iterable<String> reverseIterator(){
        return () -> new Iterator<String>() {

            private int i = appleStore.size() - 1;

            @Override
            public boolean hasNext() {
                if (i > -1){
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public String next() {
                return appleStore.get(i--);
            }

            @Override
            public void remove() {
                System.out.println("not defined");
            }
        };
    }
}
