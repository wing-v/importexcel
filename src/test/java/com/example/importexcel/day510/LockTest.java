package com.example.importexcel.day510;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {
    public static void main(String[] args) {
        new ReentrantLock();

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

        ArrayList<String> list = new ArrayList<>();
//        list.removeIf();
    }
}
