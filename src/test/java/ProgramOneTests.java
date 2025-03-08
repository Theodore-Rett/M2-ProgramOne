import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramOneTests {

    @Test
    public void testSortedArray() {
        int[] arrOne = {1, 2, 3, 4, 5};

        assertEquals(1, Main.getkthLowest(1, arrOne, arrOne.length));
        assertEquals(2, Main.getkthLowest(2, arrOne, arrOne.length));
        assertEquals(3, Main.getkthLowest(3, arrOne, arrOne.length));
    }

    @Test
    public void testReverseSortedArray() {
        int[] arrTwo = {5, 4, 3, 2, 1}; // Assuming this is arrTwo based on expected values

        assertEquals(1, Main.getkthLowest(1, arrTwo, arrTwo.length));
        assertEquals(2, Main.getkthLowest(2, arrTwo, arrTwo.length));
        assertEquals(3, Main.getkthLowest(3, arrTwo, arrTwo.length));
    }

    @Test
    public void testRandomSortedArray() {
        int[] arrThree = {3, 4, 1, 2, 5}; // Assuming this is arrThree based on expected values

        assertEquals(1, Main.getkthLowest(1, arrThree, arrThree.length));
        assertEquals(2, Main.getkthLowest(2, arrThree, arrThree.length));
        assertEquals(3, Main.getkthLowest(3, arrThree, arrThree.length));
    }

    @Test
    public void testEmptyArray() {
        int[] emptyArray = {};

        try {
            Main.getkthLowest(1, emptyArray, emptyArray.length);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Array is empty", e.getMessage());
        }
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] arrayWithDuplicates = {3, 3, 3, 3, 3};

        assertEquals(3, Main.getkthLowest(1, arrayWithDuplicates, arrayWithDuplicates.length));
        assertEquals(3, Main.getkthLowest(2, arrayWithDuplicates, arrayWithDuplicates.length));
        assertEquals(3, Main.getkthLowest(3, arrayWithDuplicates, arrayWithDuplicates.length));
    }

    @Test
    public void testArrayWithMixedDuplicates() {
        int[] mixedDuplicates = {5, 5, 3, 3, 7, 7, 1, 1};

        assertEquals(1, Main.getkthLowest(1, mixedDuplicates, mixedDuplicates.length));
        assertEquals(1, Main.getkthLowest(2, mixedDuplicates, mixedDuplicates.length));
        assertEquals(3, Main.getkthLowest(3, mixedDuplicates, mixedDuplicates.length));
        assertEquals(3, Main.getkthLowest(4, mixedDuplicates, mixedDuplicates.length));
        assertEquals(5, Main.getkthLowest(5, mixedDuplicates, mixedDuplicates.length));
    }

    @Test
    public void testSingleElementArray() {
        int[] singleElement = {42};

        assertEquals(42, Main.getkthLowest(1, singleElement, singleElement.length));
    }

    @Test
    public void testLargeK() {
        int[] array = {1, 2, 3, 4, 5};

        assertEquals(5, Main.getkthLowest(5, array, array.length));
    }

    @Test
    public void testNegativeNumbers() {
        int[] negativeNumbers = {-10, -5, -20, -15, -1};

        assertEquals(-20, Main.getkthLowest(1, negativeNumbers, negativeNumbers.length));
        assertEquals(-15, Main.getkthLowest(2, negativeNumbers, negativeNumbers.length));
        assertEquals(-10, Main.getkthLowest(3, negativeNumbers, negativeNumbers.length));
        assertEquals(-5, Main.getkthLowest(4, negativeNumbers, negativeNumbers.length));
        assertEquals(-1, Main.getkthLowest(5, negativeNumbers, negativeNumbers.length));
    }

    @Test
    public void testNegativeAndPositive() {
        int[] mixedNumbers = {-3, 0, 5, -10, 8, 2, -1};

        assertEquals(-10, Main.getkthLowest(1, mixedNumbers, mixedNumbers.length));
        assertEquals(-3, Main.getkthLowest(2, mixedNumbers, mixedNumbers.length));
        assertEquals(-1, Main.getkthLowest(3, mixedNumbers, mixedNumbers.length));
        assertEquals(0, Main.getkthLowest(4, mixedNumbers, mixedNumbers.length));
        assertEquals(2, Main.getkthLowest(5, mixedNumbers, mixedNumbers.length));
    }
}
