package com.example.importexcel.day506;

public class ReferenceCountingGC {
    public Object instance;

    public ReferenceCountingGC(String name) {
    }

    public static void main(String[] args) {
        ReferenceCountingGC a = new ReferenceCountingGC("objA");
        ReferenceCountingGC b = new ReferenceCountingGC("objB");

        a.instance = b;
        b.instance = a;

        a = null;
        b = null;

        System.out.println("a :"+a);
        System.out.println("b :"+b);
    }
}
