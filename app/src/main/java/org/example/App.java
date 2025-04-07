package org.example;

import java.util.ArrayList;

public class App {
    public static class FuzzyFinder {
        public int linearSearchGolden(ArrayList<Fuzzy> fuzzies) {
            for (int i = 0; i < fuzzies.size(); i++) {
                if (fuzzies.get(i).color.equals("gold")) {
                    return i;
                }
            }
            return -1;
        }

        public int binarySearchGolden(ArrayList<Fuzzy> fuzzies) {
            int left = 0;
            int right = fuzzies.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                String midColor = fuzzies.get(mid).color;
                if (midColor.equals("gold")) {
                    return mid;
                } else if (midColor.compareTo("gold") < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }

        public int findColdPricklyIndex(ArrayList<Fuzzy> fuzzies) {
            for (int i = 0; i < fuzzies.size(); i++) {
                if (fuzzies.get(i).color.equals("pokey")) {
                    return i;
                }
            }
            return -1;
        }
    }

    // Method for linear search analysis
    static String linearSearchAnalysis() {
        return "Linear Search Worst Case: O(n) - Must check every element in the list";
    }

    // Method for binary search analysis
    static String binarySearchAnalysis() {
        return "Binary Search Worst Case: O(log n) - Only works on sorted lists";
    }

    public static void main(String[] args) {
        FuzzyListGenerator generator = new FuzzyListGenerator();
        FuzzyFinder finder = new FuzzyFinder();

        // Using the FuzzyListGenerator to create the lists
        ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
        ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();

        // Adding a "pokey" Fuzzy to randomFuzzies
        randomFuzzies.add(new Fuzzy("pokey"));

        // Testing the linear and binary searches
        System.out.println("Golden Fuzzy Tests:");
        System.out.println("Linear (sorted): " + finder.linearSearchGolden(sortedFuzzies));
        System.out.println("Binary (sorted): " + finder.binarySearchGolden(sortedFuzzies));
        System.out.println("Linear (random): " + finder.linearSearchGolden(randomFuzzies));
        System.out.println("Binary (random): " + finder.binarySearchGolden(randomFuzzies));

        // Testing for "pokey" Fuzzy in random list
        System.out.println("\nCold Prickly Tests:");
        System.out.println("Prickly search: " + finder.findColdPricklyIndex(randomFuzzies));

        // Printing algorithm analysis
        System.out.println("\nAlgorithm Analysis:");
        System.out.println(linearSearchAnalysis());
        System.out.println(binarySearchAnalysis());
    }
}
