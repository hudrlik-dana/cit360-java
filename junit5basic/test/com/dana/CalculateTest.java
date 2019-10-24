package com.dana;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.dana.Calculate.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculateTest {

@Nested
class Equals {

    // assertEquals(expected, actual)
    @Test
    public void test_addNumbers() {
        // testing passes
        assertEquals(7, Calculate.addNumbers(3, 4));
        // testing fails
        // assertEquals(10, Calculate.addNumbers(3, 4));
    }

    // assertEquals(expected, actual)
    @Test
    public void test_subtractNumbers() {
        // testing passes
        assertEquals(5, Calculate.subtractNumbers(8, 3));
        // testing fails
        // assertEquals(21, Calculate.subtractNumbers(8, 3));
    }

    // assertEquals() expected, actual  concatenates 2 strings
    @Test
    public void test_ConcatString() {
        //Calculate calculate = new Calculate();
        // test passes
        assertEquals("danahudrlik", concatStrings("dana", "hudrlik"));
        // test fails
        //   assertEquals("dahudrlik", Calculate.concatStrings("dan", "hudr"));
        // test passes
        assertEquals("tireddana", concatStrings("tired", "dana"));
    }
}

@Nested
class SameAndNotSame {

    // assertSame(expected, actual)
    @Test
    public void test_sameNumbers() {
        // testing passes
        assertSame(true, sameNumbers(4, 4));
        assertSame(false, sameNumbers(5, 4));
        // testing fails
        // assertSame(true, Calculate.sameNumbers(5, 4));
    }

    //assertNotSame(expected, actual)
    @Test
    public void test_notSameNumbers() {
        // passing test
        Assertions.assertNotSame(true, differentCharacters("a", "b"));
        assertNotSame(false, differentCharacters("a", "a"));
        // failing test
        // assertNotSame(true, Calculate.differentCharacters("b", "b"));
    }
}

@Nested
class TrueFalse {

    // assertTrue()
    @Test
    public void test_true_isNumberOdd() {
        // test passes - if number is odd expected value true
        assertTrue(isNumberOdd(9));
        // test fails
        // assertTrue(Calculate.isNumberOdd(10));
    }

    // assertFalse()
    @Test
    public void test_false_isNumberEven() {
        // passing test - if number is even expected value true
        assertFalse(Calculate.isNumberEven(7));
        // failing test - if number is odd - expected value false
        // assertFalse(Calculate.isNumberEven(6));
    }

    // assertFalse() compares strings
    @Test
    public void test_compareStrings() {
        Calculate calculate = new Calculate();
        // test passes - it is false
        assertFalse(calculate.compareStrings("dan", "dana"));
        // test fails - it is true
        // assertFalse(calculate.compareStrings("dana", "dana"));
    }
}

@Nested
class NullNotNull {

    // test if not null using HashMap key-value pairs
    @Test
    public void test_notNullKeyValuePair_usingKey_State() {
        // test passes
        assertNotNull(notNullKeyValuePair("Utah"));
        // test fails, Big Bear is the value not the key
        // assertNotNull(Calculate.notNullKeyValuePair("Big Bear"));
        // test fails, Oklahoma is not in the Map
        // assertNotNull(Calculate.notNullKeyValuePair("Oklahoma"));
    }

    // test if null
    @Test
    public void test_nullKeyValuePair_usingKey() {
        // test passes - value null
        assertNull(notNullKeyValuePair(""));
        assertNull(notNullKeyValuePair("null"));
        // test fails - actual Herriman, expected null
        // assertNull(Calculate.notNullKeyValuePair("Utah"));
    }
}
    // assertArrayEquals
    @Test
    public void test_addOneToArray() {
        // creat the object from Calculate class
        Calculate calculate = new Calculate();
        // test pass adding 1 to each actual value in array
        // need to initialize the array { }
        int[] expected = new int[]{4, 10};
        assertArrayEquals(expected, calculate.addOneToArray(new int[]{3, 9}));
    }

@Nested
class ThrowsExceptions {

    // assertThrows(nullPointerException.class)
    // assertThrows(runtimeException.class)
    // using lambda expression for reusable code block, can be put around
    // specific blocks of code
    @Test
    public void test_succeedsWhenItThrowsException() {
        String example = null;
        // throws a NullPointerException when example is null
        assertThrows(NullPointerException.class,
                () -> {
                    example.length();
                });
        // throws RuntimeException when variable example is null
        assertThrows(RuntimeException.class,
                () -> {
                    example.length();
                });
    }

    // assertThrows(ArithmeticException)
    // using lambda expression, (not belonging to a class,
    // treats function as a method() argument so code block can be reused)
    @Test
    public void test_divideNumbers() {
        // test passes
        assertThrows(ArithmeticException.class, () -> Calculate.divideNumbers(2, 0),
                "Throws ArithmeticException when denominator equals zero");
        // test fails
        // assertThrows(ArithmeticException.class, () -> Calculate.divideNumbers(0, 2),
        // "Throws ArithmeticException when denominator is zero");
    }
}
}