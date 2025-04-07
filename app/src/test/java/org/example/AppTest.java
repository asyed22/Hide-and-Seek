package org.example;

import static org.junit.Assert.*;  // Import for assertions
import org.junit.Test;  // Import for JUnit annotations
import java.util.ArrayList;

public class AppTest {

    // Test for Linear Search Golden using a sorted list of Fuzzies
    @Test
    public void testLinearSearchGolden() {
        FuzzyListGenerator generator = new FuzzyListGenerator();
        App.FuzzyFinder finder = new App.FuzzyFinder();  // Correctly reference the nested FuzzyFinder class

        // Generate sorted Fuzzies list
        ArrayList<Fuzzy> fuzzies = generator.sortedRainbowFuzzies();

        // Run linear search for the golden fuzzy
        assertEquals(7, finder.linearSearchGolden(fuzzies));  // gold should be at index 7
    }

    // Test for Binary Search Golden using a sorted list of Fuzzies
    @Test
    public void testBinarySearchGolden() {
        FuzzyListGenerator generator = new FuzzyListGenerator();
        App.FuzzyFinder finder = new App.FuzzyFinder();  // Correctly reference the nested FuzzyFinder class

        // Generate sorted Fuzzies list
        ArrayList<Fuzzy> fuzzies = generator.sortedRainbowFuzzies();

        // Run binary search for the golden fuzzy
        assertEquals(7, finder.binarySearchGolden(fuzzies));  // gold should be at index 7
    }

    // Test for finding the index of the "pokey" fuzzy
    @Test
    public void testFindColdPricklyIndex() {
        FuzzyListGenerator generator = new FuzzyListGenerator();
        App.FuzzyFinder finder = new App.FuzzyFinder();  // Correctly reference the nested FuzzyFinder class

        // Generate a randomized Fuzzies list and add the "pokey" fuzzy
        ArrayList<Fuzzy> fuzzies = generator.randomizedRainbowFuzzies();
        fuzzies.add(new Fuzzy("pokey"));

        // Ensure that "pokey" is found in the list
        assertTrue(finder.findColdPricklyIndex(fuzzies) >= 0);  // Should find pokey Fuzzy
    }

    // Test for analyzing linear search complexity
    @Test
    public void testLinearSearchAnalysis() {
        String result = App.linearSearchAnalysis();
        assertEquals("Linear Search Worst Case: O(n) - Must check every element in the list", result);
    }

    // Test for analyzing binary search complexity
    @Test
    public void testBinarySearchAnalysis() {
        String result = App.binarySearchAnalysis();
        assertEquals("Binary Search Worst Case: O(log n) - Only works on sorted lists", result);
    }
}
