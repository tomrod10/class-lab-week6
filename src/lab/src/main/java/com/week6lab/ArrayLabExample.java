package com.week6lab;

import java.util.Arrays;

import com.github.javafaker.Faker;

public class ArrayLabExample {
    // create two arrays
    static final Integer minSize = 8;
    static final Integer maxSize = 12;
    private static String[] class1;
    private static String[] class2;
    private static String[] classResult;
    // create np fake names
    static Faker faker = new Faker();

    // create names
    public static void createNames(String[] arr) {
        // populate array
        for (int i = 0; i < arr.length; i += 1) {
            String fName = faker.name().firstName();
            String lName = faker.name().lastName();
            String name = fName + ' ' + lName;
            arr[i] = name;
        }
    }

    // print array
    public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i += 1) {
            System.out.printf("[%d] %s\n", i + 1, arr[i]);
        }
    }

    public static Integer randomRange(Integer minSize, Integer maxSize) {
        return minSize + (int) (Math.random() * ((maxSize - minSize) + 1));
    }

    public static String[] createClass(Integer n) {
        String[] c = new String[n];
        createNames(c);
        Arrays.sort(c);
        return c;
    }

    public static void main(String[] args) {
        // random class size
        final Integer n = randomRange(minSize, maxSize);
        // create sorted class of students
        final Integer n1 = (int) (Math.random() * n);
        class1 = createClass(n1);
        System.out.println();
        System.out.printf("-------- class 1: %d students--------\n", n1);
        print(class1);
        // create sorted class of students
        final Integer n2 = n - n1;
        class2 = createClass(n2);
        System.out.println();
        System.out.printf("-------- class 2: %d students --------\n", n2);
        print(class2);
        // create the resulting classes joined together
        classResult = new String[n];
        /*
         * STUDENTS NEED TO ADD CODE HERE TO EFFICIENTLY JOIN THE CLASSROOMS
         */
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        while (p1 < n1 && p2 < n2) {
            int comparison = class1[p1].compareTo(class2[p2]);

            if (comparison <= 0) {
                classResult[p3] = class1[p1];
                p1++;
            } else {
                classResult[p3] = class2[p2];
                p2++;
            }
            p3++;
        }

        while (p1 < n1) {
            classResult[p3] = class1[p1];
            p1++;
            p3++;
        }

        while (p2 < n2) {
            classResult[p3] = class2[p2];
            p2++;
            p3++;
        }

        // print the classes joined together
        System.out.println();
        System.out.printf("-------- result class: %d students --------\n", n);
        print(classResult);
    }
}
