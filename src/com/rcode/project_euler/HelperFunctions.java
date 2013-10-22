package com.rcode.project_euler;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ANTHONY
 * Date: 10/16/13
 * Time: 1:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelperFunctions {

    /**
     * Gets if a number is even
     *
     * @param num Number to test
     * @return If a number is even
     */
    public static boolean isEven(long num) {
        return (num % 2 == 0);
    }

    /**
     * Gets if the number passed in is prime
     *
     * @param num Number to test
     * @return If the number is prime
     */
    public static boolean isPrime(long num) {
        // 0 and 1 are not prime numbers
        if (num == 0)
            return false;
        else if (num == 1)
            return false;

        // Test all possible factors of the number
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        // The number must be prime
        return true;
    }

    /**
     * Gets if a number is a palindrome
     *
     * @param num The number to test
     * @return If the number is a palindrome
     */
    public static boolean isPalindrome(long num) {
        String numString = String.valueOf(num);
        for (int i = 0; i < numString.length() / 2; i++) {
            if (numString.charAt(i) != numString.charAt(numString.length() - 1 - i))
                return false;
        }
        return true;
    }

    /**
     * Gets the greatest number divisible by both parameters
     *
     * @param a Number 1
     * @param b Number 2
     * @return The GCD of the two parameters
     */
    public static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }

    /**
     * Gets the lowest number divisible by a and b
     *
     * @param a Number 1
     * @param b Number 2
     * @return The lowest number divisible by a and b
     */
    public static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    /**
     * Gets the lcm of a number from the parameter to 1
     *
     * @param num Number to test
     * @return The lcm of the number to 1
     */
    public static long recursiveLcm(long num) {
        if (num == 1 || num == 0) {
            return num;
        } else {
            return HelperFunctions.lcm(num, recursiveLcm(num - 1));
        }
    }

    /**
     * Recursively gets the sum of squares of numbers starting from num to 1
     *
     * @param num Number to start at
     * @return The sum of the squares
     */
    public static long sumOfSquares(long num) {
        if (num == 1 || num == 0) {
            return num;
        } else {
            return (num * num) + sumOfSquares(num - 1);
        }
    }

    /**
     * Iteratively gets the square of the sum of the numbers [num : 1]
     *
     * @param num Number to start at
     * @return The square of the sum
     */
    public static long squareOfSum(long num) {
        long sum = 0;
        for (long i = num; i > 0; i--) {
            sum += i;
        }
        return (sum * sum);
    }

    /**
     * Gets all prime numbers below <em>max</em> using the sieve of sundaram method
     *
     * @param max Upper limit
     * @return An array of prime numbers up until <em>max</em>
     */
    public static int[] sieveOfSundaram(int max) {
        int n = max / 2;
        boolean[] isPrime = new boolean[max];

        Arrays.fill(isPrime, true);

        for (int i = 1; i < n; i++) {
            for (int j = i; j <= (n - i) / (2 * i + 1); j++) {
                isPrime[i + j + 2 * i * j] = false;
            }
        }

        int[] primes = new int[max];
        int found = 0;
        if (max > 2) {
            primes[found++] = 2;
        }
        for (int i = 1; i < n; i++) {
            if (isPrime[i]) {
                primes[found++] = i * 2 + 1;
            }
        }

        return Arrays.copyOf(primes, found);
    }

    /**
     * Gets an array of primes up until a num using the sieveOfAtkin method
     *
     * @param num The upper limit
     * @return An array of primes up until <em>num</em>
     */
    public static Integer[] sieveOfAtkin(int num) {
        boolean[] sieve = new boolean[1000 + 1];
        int limitSqrt = (int) Math.sqrt(1000f);
        Arrays.fill(sieve, false);
        sieve[0] = false;
        sieve[1] = false;
        sieve[2] = true;
        sieve[3] = true;

        for (int x = 1; x <= limitSqrt; x++) {
            for (int y = 1; y <= limitSqrt; y++) {
                int n = (4 * x * x) + (y * y);
                if ((n <= 1000) && (n % 12 == 1 || n % 12 == 5)) {
                    sieve[n] = !sieve[n];
                }

                n = (3 * x * x) + (y * y);
                if ((n <= 1000) && (n % 12 == 7)) {
                    sieve[n] = !sieve[n];
                }

                n = (3 * x * x) - (y * y);
                if ((x > y) && (n <= 1000) && (n % 12 == 11)) {
                    sieve[n] = !sieve[n];
                }
            }
        }

        for (int n = 5; n <= limitSqrt; n++) {
            if (sieve[n]) {
                int x = n * n;
                for (int i = x; i <= 1000; i += x) {
                    sieve[i] = false;
                }
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i])
                result.add(i);
        }

        return result.toArray(new Integer[0]);
    }

    /**
     * Counts the number of divisors for a number
     *
     * @param num Number to get the divisors for
     * @return The number of divisors for a number
     */
    public static long countDivisors(long num) {
        long count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) count += (num / i == i ? 1 : 2);
        }
        return count;
    }

    /**
     * Gets the length of a collatz sequence chain
     *
     * @param start Start number
     * @return Length of the chain
     */
    public static long collatzChainLength(long start) {
        long chainLength = 1;
        long i = start;
        while (i != 1) {
            ++chainLength;
            if (HelperFunctions.isEven(i)) {
                i = i / 2;
            } else {
                i = (3 * i) + 1;
            }
        }
        return chainLength;
    }

    /**
     * Gets if a year is a leap year
     *
     * @param year The year to test
     * @return If a year is a leap year
     */
    public static boolean isLeapYear(long year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    /**
     * Gets the factorial of a number
     *
     * @param num Number to start at
     * @return The factorial
     */
    public static long factorial(long num) {
        if (num == 0) return 1;

        if (num == 2 || num == 1) {
            return num;
        } else {
            return num * factorial(num - 1);
        }
    }

    /**
     * Gets the factorial of a large number
     *
     * @param num Number to start at
     * @return The factorial
     */
    public static BigInteger bigFactorial(BigInteger num) {
        if (num.equals(BigInteger.ZERO)) return BigInteger.ONE;
        if (num.equals(BigInteger.valueOf(2L)) ||
                num.equals(BigInteger.valueOf(1L))) {
            return num;
        } else {
            return num.multiply(bigFactorial(num.subtract(BigInteger.ONE)));
        }
    }

    /**
     * Gets a list of divisors of a number
     *
     * @param num The number to get divisors for
     * @return The list of divisors
     */
    public static List<Long> getDivisors(long num) {
        List<Long> nums = new ArrayList<Long>();
        for (long i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i == Math.sqrt(num) || i == 1) {
                    nums.add(i);
                } else {
                    nums.add(i);
                    nums.add(num / i);
                }
            }
        }
        return nums;
    }

    /**
     * Gets the sum of the divisors of a number (<em>seems common in Project Euler problems</em>)
     *
     * @param num The number to get the sum of divisors for
     * @return The sum of divisors
     */
    public static long getSumOfDivisors(long num) {
        List<Long> divisors = getDivisors(num);
        long sum = 0;
        for (Long l : divisors) {
            sum += l;
        }
        return sum;
    }

    /**
     * Gets if a number is amicable
     * <em>
     * <p>A number is amicable iff a!=b and the sum of the divisors of a == b and then sum of the </p>
     * <p>divisors of b == a</p>
     * </em>
     *
     * @param num
     * @return
     */
    public static boolean isAmicableNumber(long num) {
        long amicableNum = getSumOfDivisors(num);
        if (amicableNum == num) return false;
        return getSumOfDivisors(amicableNum) == num;
    }

    /**
     * Gets the sum of all char indexes in a word
     *
     * @param word Word to get the score for
     * @return The word score
     */
    public static long getWordScore(String word) {
        long sum = 0;
        for (int i = 0; i < word.length(); i++) sum += word.charAt(i) - 64;
        return sum;
    }

    /**
     * Gets if a number is an abundant number.
     * @param num Number to test
     * @return If the number is abundant
     */
    public static boolean isAbundantNumber(long num) {
        long sum = 0;
        for (long i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += (i == 1 || i*i==num) ? i : i + (num / i);
            }
        }
        return sum > num;
    }

    /**
     * Gets a word from a number in between 1-999
     * @param num
     *   Number to get the word for
     * @return
     *   The number in words with British usage
     */
    public static String numToWords(long num) {
        String[] ones = new String[] {
                "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine"
        };

        int[] onesLen = new int[] {
                3, 3, 5, 4, 5, 3, 5, 5, 4
        };

        String[] teens = new String[] {
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen"
        };

        int[] teensLen = new int[] {
                6, 6, 8, 8, 7, 7, 9, 8, 8
        };

        String[] tens = new String[] {
                "ten", "twenty", "thirty", "forty", "fifty", "sixty",
                "seventy", "eighty", "ninety"
        };

        int[] tensLen = new int[] {
                3, 5, 6, 5, 5, 5, 7, 6, 6
        };

        String numStr = String.valueOf(num);
        StringBuilder result = new StringBuilder();

        int one = Integer.valueOf(String.valueOf(numStr.charAt(numStr.length() - 1)));
        result.insert(0, one > 0 ? ones[one - 1] + " " : "");

        if (num >= 10) {
            int ten = Integer.valueOf(String.valueOf(numStr.charAt(numStr.length() - 2)));

            if (ten > 1) {
                result.insert(0, tens[ten - 1] + " ");
            } else if (ten == 0) {

            } else {
                result = new StringBuilder(one > 0 ? teens[one - 1] : "ten");
            }
        }

        if (num >= 100) {
            int hundred = Integer.valueOf(String.valueOf(numStr.charAt(numStr.length() - 3)));
            int ten = Integer.valueOf(String.valueOf(numStr.charAt(numStr.length() - 2)));
            result.insert(0, ones[hundred - 1] + (one == 0 && ten == 0 ? " hundred " : " hundred and "));
        }

        return result.toString();
    }

    /**
     * Returns a 2-D array that represents a triangle from Project Euler questions
     * (<em>ie</em>)
     * <block>
     *        94
     *      03  02
     *     03 06 23
     * </block>
     * Becomes:
     * <block>
     *     94 0  0
     *     3  2  0
     *     3  6  23
     * </block>
     * @param filename Name of the file where the triangle is stored
     * @return the array representation of the triangle
     */
    public static int[][] getTriangleData(String filename) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String line;
            int lines = 0;

            while (in.readLine() != null) {
                lines++;
            }
            in.close();

            int[][] result = new int[lines][lines];
            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < lines; j++) {
                    result[i][j] = 0;
                }
            }

            in = new BufferedReader(new FileReader(filename));
            int lineNum = 0;
            while ((line = in.readLine()) != null) {
                String[] lineSplit = line.split(" ");
                if (lineSplit.length > 1) {
                    for (int i = 0; i < lineSplit.length; i++)
                        result[lineNum][i] = Integer.parseInt(lineSplit[i]);
                } else {
                    result[lineNum][0] = Integer.parseInt(lineSplit[0]);
                }
                lineNum++;
            }
            in.close();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets all possible permutations of a string
     * @param str The string to permutate
     * @return An ArrayList of all possible permutations
     */
    public static LinkedList<String> getPermutations(String str) {
        LinkedList<String> result = new LinkedList<String>();

        if (str.length() == 1) {
            result.add(str);
            return result;
        } else  {
            char first = str.charAt(0);
            String rest = str.substring(1);

            List<String> permOfRest = getPermutations(rest);

            for (String perm : permOfRest) {
                List<String> additions = insertAtAllPositions(first, perm);
                result.addAll(additions);
            }
        }
        return result;
    }

    /**
     * Used in conjunction with the Collections.sort function to sort a list
     * in alphabetical order
     */
    public static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
        public int compare(String str1, String str2) {
            int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
            if (res == 0) {
                res = str1.compareTo(str2);
            }
            return res;
        }
    };

    /**
     * Inserts the char, c, back into the permutation, s
     * @param c The char to insert back
     * @param s The string to insert the char into
     * @return The permutation with the leading char, c
     */
    private static List<String> insertAtAllPositions(char c, String s) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            result.add(s.substring(0, i) + c + s.substring(i));
        }
        return result;
    }
}
