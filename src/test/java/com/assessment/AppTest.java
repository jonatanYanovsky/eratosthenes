package com.assessment;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testNegativeInput() {
        List<Integer> result = App.sieveOfEratosthenes(-10);

        assertEquals(result, new ArrayList<Integer>());
    }

    @Test
    void testZero() {
        List<Integer> result = App.sieveOfEratosthenes(0);

        assertEquals(result, new ArrayList<Integer>());
    }

    @Test
    void testOne() {
        List<Integer> result = App.sieveOfEratosthenes(1);

        assertEquals(result, new ArrayList<Integer>());
    }

    @Test
    void testTwo() {
        List<Integer> result = App.sieveOfEratosthenes(2);
        List<Integer> comparisonValue = new ArrayList<Integer>();
        comparisonValue.add(2);

        assertEquals(result, comparisonValue);
    }

    @Test
    void testTen() {
        List<Integer> result = App.sieveOfEratosthenes(10);
        List<Integer> comparisonValue = new ArrayList<Integer>();
        comparisonValue.add(2);
        comparisonValue.add(3);
        comparisonValue.add(5);
        comparisonValue.add(7);

        assertEquals(result, comparisonValue);
    }

    @Test
    void testOneHundred() {
        List<Integer> result = App.sieveOfEratosthenes(100);
        List<Integer> comparisonValue = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);

        assertEquals(result, comparisonValue);
    }
}
