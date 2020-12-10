package com.company;

import Examples.BinarySearch;
import Examples.BubbleSort;
import Examples.Converter;
import Examples.Hierarchy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Binary search:");
        BinarySearch.run();
        System.out.println("Bubble sort:");
        BubbleSort.run();
        System.out.println("Converter:");
        Converter.run();
        System.out.println("Hierarchy:");
        Hierarchy.run();
    }
}
