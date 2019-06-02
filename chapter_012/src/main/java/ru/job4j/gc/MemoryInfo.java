package ru.job4j.gc;

public class MemoryInfo {

    public static void getInfo() {

        int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        System.out.println();
        System.out.println("Heap statistics MB");
        System.out.println("Used memory: " + (runtime.totalMemory() - runtime.freeMemory()) / mb);
        System.out.println("Free memory: " + runtime.freeMemory() / mb);
        System.out.println("Total memory: " + runtime.totalMemory() / mb);
        System.out.println();
    }
}
