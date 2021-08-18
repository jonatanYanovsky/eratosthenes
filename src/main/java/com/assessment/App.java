package com.assessment;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Sieve of Eratosthenes is the earliest means of finding prime numbers. A description
can be found at https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes . Write an
implementation of this in Java. The program should take a maximum integer value as an
input, and return the list of prime numbers between 0 and that number. Provide unit
tests.
 */

public final class App {
    public static void main(String[] args) {
        System.out.println("Sieve Of Eratosthenes");

        int n = 30; // default value
        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("unable to parse program arguments into an integer: " + args[0]);
                System.out.println(e.getLocalizedMessage());
                System.exit(1);
            }
        }

        List<Integer> primes = sieveOfEratosthenes(n);

        for (int i : primes) {
            System.out.print(i + " ");
        }
    }


    /*
    pseudocode taken from wikipedia:


    algorithm Sieve of Eratosthenes is
        input: an integer n > 1.
        output: all prime numbers from 2 through n.

        let A be an array of Boolean values, indexed by integers 2 to n,
        initially all set to true.
        
        for i = 2, 3, 4, ..., not exceeding √n do
            if A[i] is true
                for j = i^2, i^2+i, i^2+2i, i^2+3i, ..., not exceeding n do
                    A[j] := false

        return all i such that A[i] is true.
    */
    static List<Integer> sieveOfEratosthenes(int n) {
        List<Integer> primes = new ArrayList<Integer>();

        if (n < 0) {
            return primes;
        }

        int length = n + 1;
        // n = 5
        // 0 1 2 3 4 5

        boolean[] A = new boolean[length]; // from 0 to n, let indices represent the number they are equal to
        Arrays.fill(A, true);

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (A[i]) {
                for (int j = (int) Math.pow(i, 2); j <= n; j += i) {
                    A[j] = false;
                }
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (A[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

}
