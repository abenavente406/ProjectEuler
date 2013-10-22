import java.math.BigInteger;

import static com.rcode.project_euler.HelperFunctions.*;

/**
 * Class description here
 *
 * @version 10/18/13
 * @author: ANTHONY
 */
public class HelperFunctionTests {

    /**
     * Function used for testing
     *
     * @param expression Function to test
     * @return If the function passed or failed (true/false)
     */
    private static boolean assertExpression(boolean expression) {
        return expression;
    }

    public static void main(String[] args) {

        String help = "----------------------\n" +
                "COMMANDS FOR EXECUTION\n" +
                "----------------------\n" +
                "-p     : testPrime()\n" +
                "-e     : testEven()\n" +
                "-pa    : testPalindrome()\n" +
                "-gcd   : testGcd()\n" +
                "-lcm   : testLcm()\n" +
                "-rlcm  : testRecursiveLcm()\n" +
                "-s     : testSumOfSquare()\n" +
                "-ss    : testSquareOfSum()\n" +
                "-sos   : testSieveOfSundaram()\n" +
                "-soa   : testSieveOfAtkin()\n" +
                "-d     : testCountDivisors()\n" +
                "-l     : testLeapYear()\n" +
                "-!     : testFactorial() \n" +
                "-!!    : testBigFactorial()";
        String test = args.length > 0 ? args[0] : "all";

        if (args == null) {
            testPrime();
            testEven();
            testPalindrome();
            testGcd();
            testLcm();
            testRecursiveLcm();
            testSumOfSquares();
            testSquareOfSum();
            testSieveOfSundaram();
            testSieveOfAtkin();
            testCountDivisors();
            testCollatzChain();
            testLeapYear();
            testFactorial();
        } else {
            if (test.equals("-help") || test.equals("-h")) {
                System.out.println(help);
            } else {
                if (test.equals("all") || test.equals("-p")) testPrime();
                if (test.equals("all") || test.equals("-e")) testEven();
                if (test.equals("all") || test.equals("-pa")) testPalindrome();
                if (test.equals("all") || test.equals("-gcd")) testGcd();
                if (test.equals("all") || test.equals("-lcm")) testLcm();
                if (test.equals("all") || test.equals("-rlcm")) testRecursiveLcm();
                if (test.equals("all") || test.equals("-s")) testSumOfSquares();
                if (test.equals("all") || test.equals("-ss")) testSquareOfSum();
                if (test.equals("all") || test.equals("-sos")) testSieveOfSundaram();
                if (test.equals("all") || test.equals("-soa")) testSieveOfAtkin();
                if (test.equals("all") || test.equals("-d")) testCountDivisors();
                if (test.equals("all") || test.equals("-c")) testCollatzChain();
                if (test.equals("all") || test.equals("-l")) testLeapYear();
                if (test.equals("all") || test.equals("-!")) testFactorial();
            }
        }
    }

    /**
     * Prints the name of the test
     *
     * @param test Test name/description
     */
    private static void printTest(String test) {
        int chars = test.length();
        int padding = 5;
        for (int i = 0; i < (padding * 2) + chars; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < (padding * 2) + chars; i++) {
            if (i < padding)
                System.out.print(" ");
            else if (i < padding + chars)
                System.out.print(test.charAt(i - padding));
            else
                System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < (padding * 2) + chars; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Tests the isPrime function
     */
    private static void testPrime() {
        boolean passed = true;
        printTest("TESTING PRIME NUMBERS");
        passed &= isPrime(5);
        passed &= !isPrime(6);
        passed &= !isPrime(81);
        passed &= isPrime(29);
        passed &= isPrime(13);
        System.out.println("5 should be a prime number:      " + assertExpression(isPrime(5)));
        System.out.println("6 should not be a prime number:  " + assertExpression(!isPrime(6)));
        System.out.println("81 should not be a prime number: " + assertExpression(!isPrime(81)));
        System.out.println("29 should be a prime number:     " + assertExpression(isPrime(29)));
        System.out.println("13 should be a prime number:     " + assertExpression(isPrime(13)));
        System.out.println("FUNCTION isPrime():              " + (passed ? "PASSED" : "FAILED"));
        System.out.println();
    }

    private static void testEven() {
        boolean passed;
        printTest("TESTING EVEN NUMBERS");
        passed = true;
        passed &= isEven(10);
        passed &= !isEven(111241);
        passed &= isEven(12410);
        System.out.println("10 should be an even number:         " + assertExpression(isEven(10)));
        System.out.println("111241 should not be an even number: " + assertExpression(!isEven(111241)));
        System.out.println("12410 should be an even number:      " + assertExpression(isEven(12410)));
        System.out.println("FUNCTION isEven():                   " + (passed ? "PASSED" : "FAILED"));
        System.out.println();
    }

    private static void testPalindrome() {
        boolean passed;
        printTest("TESTING PALINDROME");
        passed = true;
        passed &= isPalindrome(1);
        passed &= isPalindrome(11);
        passed &= isPalindrome(1001);
        passed &= isPalindrome(1001001);
        passed &= isPalindrome(110011);
        passed &= !isPalindrome(110001);
        System.out.println("1 is a palindrome:       " + assertExpression(isPalindrome(1)));
        System.out.println("11 is a palindrome:      " + assertExpression(isPalindrome(11)));
        System.out.println("1001 is a palindrome:    " + assertExpression(isPalindrome(1001)));
        System.out.println("1001001 is a palindrome: " + assertExpression(isPalindrome(1001001)));
        System.out.println("110011 is a palindrome:  " + assertExpression(isPalindrome(110011)));
        System.out.println("110001 is a palindrome:  " + assertExpression(isPalindrome(110001)));
        System.out.println("FUNCTION isPalindrome(): " + (passed ? "PASSED" : "FAILED"));
        System.out.println();
    }

    private static void testGcd() {
        boolean passed;
        printTest("TESTING PALINDROME");
        passed = true;
        passed &= isPalindrome(1);
        passed &= isPalindrome(11);
        passed &= isPalindrome(1001);
        passed &= isPalindrome(1001001);
        passed &= isPalindrome(110011);
        passed &= !isPalindrome(110001);
        System.out.println("1 is a palindrome:       " + assertExpression(isPalindrome(1)));
        System.out.println("11 is a palindrome:      " + assertExpression(isPalindrome(11)));
        System.out.println("1001 is a palindrome:    " + assertExpression(isPalindrome(1001)));
        System.out.println("1001001 is a palindrome: " + assertExpression(isPalindrome(1001001)));
        System.out.println("110011 is a palindrome:  " + assertExpression(isPalindrome(110011)));
        System.out.println("110001 is a palindrome:  " + assertExpression(isPalindrome(110001)));
        System.out.println("FUNCTION isPalindrome(): " + (passed ? "PASSED" : "FAILED"));
        System.out.println();
    }

    private static void testLcm() {
        boolean passed;
        printTest("TESTING LCM");
        passed = true;
        passed &= assertExpression(lcm(45, 90) == 90);
        passed &= assertExpression(lcm(1030, 90) == 9270);
        passed &= assertExpression(lcm(1030, 1125) == 231750);
        passed &= assertExpression(lcm(3120, 1125) == 234000);
        System.out.println("The lcm of 45 and 90 == 90:          " + assertExpression(lcm(45, 90) == 90));
        System.out.println("The lcm of 1030 and 90 == 9270:      " + assertExpression(lcm(1030, 90) == 9270));
        System.out.println("The lcm of 1030 and 1125 == 231750:  " + assertExpression(lcm(1030, 1125) == 231750));
        System.out.println("The lcm of 3120 and 1125 == 234000:  " + assertExpression(lcm(3120, 1125) == 234000));
        System.out.println("FUNCTION lcm():                      " + (passed ? "PASSED" : "FAILED"));
        System.out.println();
    }

    private static void testRecursiveLcm() {
        boolean passed;
        printTest("TESTING RECURSIVE LCM");
        passed = true;
        passed &= assertExpression(recursiveLcm(20) == 232792560L);
        passed &= assertExpression(recursiveLcm(10) == 2520);
        passed &= assertExpression(recursiveLcm(1) == 1);
        passed &= assertExpression(recursiveLcm(3) == 6);
        passed &= assertExpression(recursiveLcm(0) == 0);
        System.out.println("The recursive lcm of 20 == 232792560: " + assertExpression(recursiveLcm(20) == 232792560L));
        System.out.println("The recursive lcm of 10 == 2520:      " + assertExpression(recursiveLcm(10) == 2520));
        System.out.println("The recursive lcm of  1 == 1):        " + assertExpression(recursiveLcm(1) == 1));
        System.out.println("The recursive lcm of  3 == 6):        " + assertExpression(recursiveLcm(3) == 6));
        System.out.println("The recursive lcm of  0 == 0):        " + assertExpression(recursiveLcm(0) == 0));
        System.out.println("FUNCTION recursiveLcm():              " + (passed ? "PASSED" : "FAILED"));
        System.out.println();
    }

    private static void testSumOfSquares() {
        boolean passed;
        printTest("TESTING SUM OF SQUARES");
        passed = true;
        passed &= assertExpression(sumOfSquares(10) == 385);
        passed &= assertExpression(sumOfSquares(5) == 55);
        passed &= assertExpression(sumOfSquares(4) == 30);
        passed &= assertExpression(sumOfSquares(1) == 1);
        passed &= assertExpression(sumOfSquares(0) == 0);
        System.out.println("The sum of the squares from 10 == 385):        " + assertExpression(sumOfSquares(10) == 385));
        System.out.println("The sum of the squares from  5 == 55):         " + assertExpression(sumOfSquares(5) == 55));
        System.out.println("The sum of the squares from  4 == 30):         " + assertExpression(sumOfSquares(4) == 30));
        System.out.println("The sum of the squares from  1 == 1):          " + assertExpression(sumOfSquares(1) == 1));
        System.out.println("The sum of the squares from  0 == 0):          " + assertExpression(sumOfSquares(0) == 0));
        System.out.println("FUNCTION sumOfSquares():                       " + (passed ? "PASSED" : "FAILED"));
        System.out.println();
    }

    private static void testSquareOfSum() {
        boolean passed;
        printTest("TESTING SQUARE OF SUM");
        passed = true;
        passed &= assertExpression(squareOfSum(10) == 3025);
        passed &= assertExpression(squareOfSum(5) == 225);
        passed &= assertExpression(squareOfSum(4) == 100);
        passed &= assertExpression(squareOfSum(1) == 1);
        passed &= assertExpression(squareOfSum(0) == 0);
        System.out.println("The sum of the squares from 10 == 3025):        " + assertExpression(squareOfSum(10) == 3025));
        System.out.println("The sum of the squares from  5 == 225):         " + assertExpression(squareOfSum(5) == 225));
        System.out.println("The sum of the squares from  4 == 100):         " + assertExpression(squareOfSum(4) == 100));
        System.out.println("The sum of the squares from  1 == 1):           " + assertExpression(squareOfSum(1) == 1));
        System.out.println("The sum of the squares from  0 == 0):           " + assertExpression(squareOfSum(0) == 0));
        System.out.println("FUNCTION squareOfSums():                        " + (passed ? "PASSED" : "FAILED"));
        System.out.println();
    }

    private static void testSieveOfSundaram() {
        boolean passed;
        printTest("TESTING SIEVE OF SUNDARAM");
        passed = true;
        int[] primes1 = sieveOfSundaram(7920);
        passed &= primes1.length == 1000;
        int[] primes2 = sieveOfSundaram(542);
        passed &= primes2.length == 100;
        System.out.println("Attempting to get 1000 primes... " + assertExpression(primes1.length == 1000));
        System.out.println("Attempting to get 100 primes.... " + assertExpression(primes2.length == 100));
        System.out.println("FUNCTION sieveOfSundaram():      " + (passed ? "PASSED" : "FAILED"));
        System.out.println();
    }

    private static void testSieveOfAtkin() {
        boolean passed;
        printTest("TESTING SIEVE OF ATKIN");
        passed = true;
        Integer[] primes3 = sieveOfAtkin(7920);
        passed &= primes3.length == 1000;
        Integer[] primes4 = sieveOfAtkin(542);
        passed &= primes4.length == 100;
        System.out.println("Attempting to get 1000 primes... " + assertExpression(primes3.length == 1000));
        System.out.println("Attempting to get 100 primes.... " + assertExpression(primes4.length == 100));
        System.out.println("FUNCTION sieveOfAtkin():         " + (passed ? "PASSED" : "FAILED"));
        System.out.println();
    }

    private static void testCountDivisors() {
        boolean passed;
        printTest("TESTING COUNT DIVISORS");
        passed = true;
        passed &= countDivisors(1000) == 16;
        passed &= countDivisors(100) == 9;
        passed &= countDivisors(1) == 1;
        passed &= countDivisors(900) == 27;
        System.out.println("1000 has 16 divisors:      " + assertExpression(countDivisors(1000) == 16));
        System.out.println("100 has 9 divisors:        " + assertExpression(countDivisors(100) == 9));
        System.out.println("1 has 1 divisors:          " + assertExpression(countDivisors(1) == 1));
        System.out.println("900 has 27 divisors:       " + assertExpression(countDivisors(900) == 27));
        System.out.println("FUNCTION countDivisors():  " + (passed ? "PASSED" : "FAILED"));
        System.out.println();
    }

    private static void testCollatzChain() {
        boolean passed;
        printTest("TESTING COLLATZ CHAIN");
        passed = true;
        passed &= collatzChainLength(13) == 10;
        passed &= collatzChainLength(100) == 26;
        passed &= collatzChainLength(61543) == 180;
        passed &= collatzChainLength(2) == 2;
        passed &= collatzChainLength(1) == 1;
        System.out.println("Collatz chain length starting at 13 == 9:      " +
                assertExpression(collatzChainLength(13) == 10));
        System.out.println("Collatz chain length starting at 100 == 25:    " +
                assertExpression(collatzChainLength(100) == 26));
        System.out.println("Collatz chain length starting at 61543 == 179: " +
                assertExpression(collatzChainLength(61543) == 180));
        System.out.println("Collatz chain length starting at 2 == 1:       " +
                assertExpression(collatzChainLength(2) == 2));
        System.out.println("Collatz chain length starting at 1 == 0:       " +
                assertExpression(collatzChainLength(1) == 1));
        System.out.println("FUNCTION collatzChainLength():                 " + (passed ? "PASSED" : "FAILED"));
        System.out.println();
    }

    private static void testLeapYear() {
        boolean passed = true;
        printTest("TESTING LEAP YEAR");
        passed &= !isLeapYear(1);
        passed &= isLeapYear(4);
        passed &= !isLeapYear(1000);
        passed &= isLeapYear(2000);
        passed &= isLeapYear(2004);
        System.out.println("Year 1 was not a leap year:    " +
            assertExpression(!isLeapYear(1)));
        System.out.println("Year 4 was a leap year:        " +
            assertExpression(isLeapYear(4)));
        System.out.println("Year 1000 was not a leap year: " +
            assertExpression(!isLeapYear(1000)));
        System.out.println("Year 2000 was a leap year:     " +
            assertExpression(isLeapYear(2000)));
        System.out.println("Year 2004 was a leap year:     " +
            assertExpression(isLeapYear(2004)));
        System.out.println("FUNCTION isLeapYear():         " +
            (passed ? "PASSED" : "FAILED"));
    }

    private static void testFactorial() {
        boolean passed = true;
        printTest("TESTING FACTORIAL");
        passed &= bigFactorial(BigInteger.TEN).equals(new BigInteger("3628800"));
        passed &= bigFactorial(BigInteger.valueOf(20)).equals(new BigInteger("2432902008176640000"));
        passed &= factorial(1)  == 1;
        passed &= factorial(0)  == 1;  // <a href="en.wikipedia.org/wiki/Empty_Product">Empty product </a>
        System.out.println("10! == 3628800:       " + assertExpression(factorial(10) == 3628800));
        System.out.println("5! == 120:            " + assertExpression(factorial(5) == 120));
        System.out.println("1! == 1:              " + assertExpression(factorial(1) == 1));
        System.out.println("0! == 1:              " + assertExpression(factorial(0) == 1));
        System.out.println("FUNCTION factorial(): " +
                (passed ? "PASSED" : "FAILED"));
    }
}
