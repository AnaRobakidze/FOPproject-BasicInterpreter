package com;

public class Main {
    public static void main(String[] args) {
        BasicInterpreter interpreter = new BasicInterpreter();

        // Example BASIC programs
        String fib = BasicProgramExamples.fibonacci();
        String multable = BasicProgramExamples.multiplicationTable();
        String digitsum = BasicProgramExamples.digitSum();
        String largestdig = BasicProgramExamples.largestDigit();
        String palindrome = BasicProgramExamples.palindrome();
        String isprime = BasicProgramExamples.isPrime();
        String reverse = BasicProgramExamples.reverseNumber();
        String gcd = BasicProgramExamples.gcd();
        String fac = BasicProgramExamples.factorial();
        String sum = BasicProgramExamples.sumNumbers();

        // Test each program
        System.out.println("Fibonacci:");
        interpreter.evalBlock(fib);

        System.out.println("\nMultiplication Table:");
        interpreter.evalBlock(multable);

        System.out.println("\nDigit Sum:");
        interpreter.evalBlock(digitsum);

        System.out.println("\nLargest Digit:");
        interpreter.evalBlock(largestdig);

        System.out.println("\nPalindrome Check:");
        interpreter.evalBlock(palindrome);

        System.out.println("\nPrime Check:");
        interpreter.evalBlock(isprime);

        System.out.println("\nReverse Number:");
        interpreter.evalBlock(reverse);

        System.out.println("\nGCD:");
        interpreter.evalBlock(gcd);

        System.out.println("\nFactorial:");
        interpreter.evalBlock(fac);

        System.out.println("\nSum of Numbers:");
        interpreter.evalBlock(sum);
    }
}
