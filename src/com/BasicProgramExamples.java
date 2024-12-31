package com;

public class BasicProgramExamples {

    public static String fibonacci() {
        return """
            n = 10
            fib = 0
            fiba = 1
            count = 0

            while count < n
                fib = fiba + fib
                fiba = fib - fiba
                count = count + 1
            end

            puts fib
        """;
    }

    public static String multiplicationTable() {
        return """
            n = 10
            k = 1
            while k <= 10
                puts k * n
                k = k + 1
            end
        """;
    }

    public static String digitSum() {
        return """
            n = 451
            sum = 0
            while n > 0
                sum = sum + n % 10
                n = n / 10
            end
            puts sum
        """;
    }

    public static String largestDigit() {
        return """
            n = 320937
            res = 0
            while n > 0
                digit = n % 10
                if digit > res
                    res = digit
                end
                n = n / 10
            end
            puts res
        """;
    }

    public static String palindrome() {
        return """
            n = 121
            original = n
            reversed = 0
            while n > 0
                reversed = reversed * 10 + n % 10
                n = n / 10
            end
            if original == reversed
                puts "true"
            else
                puts "false"
            end
        """;
    }

    public static String isPrime() {
        return """
            n = 7
            i = 2
            res = true
            if n <= 1
                res = false
            end
            while i >= 2 && i < n
                if n % i == 0
                    res = false
                    i = n
                end
                i = i + 1
            end
            puts res
        """;
    }

    public static String reverseNumber() {
        return """
            number = 1234
            reversed = 0
            while number != 0
                digit = number % 10
                reversed = reversed * 10 + digit
                number = number / 10
            end
            puts reversed
        """;
    }

    public static String gcd() {
        return """
            a = 48
            b = 18
            temp = 0
            while b != 0
                temp = b
                b = a % b
                a = temp
            end
            puts a
        """;
    }

    public static String factorial() {
        return """
            n = 5
            fac = 1
            while n > 1
                fac = fac * n
                n = n - 1
            end
            puts fac
        """;
    }

    public static String sumNumbers() {
        return """
            n = 5
            sum = 0
            while n > 0
                sum = sum + n
                n = n - 1
            end
            puts sum
        """;
    }
}
