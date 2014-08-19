/*
 * Aks copyright from the author Marko <markoma@iki.fi>.
 * Creation date: 12.8.2014 
 */
package TestSuite.Engine;

import TestSuite.Algos.*;
import TestSuite.Arrays.*;
import java.util.ArrayList;

/**
 * TestFactory will be responsible for completing the final tests. ArrayList is
 * used to store results, which are finally printed to text file using
 * FilePrinter. Implementation for four array order scenarios with small and big
 * sizes.
 *
 * @author Marko <markoma@iki.fi>
 */
public class TestFactory {

    private final Runner runner;
    private final ArrayList<String> results;
    private final int repeat;
    private final int[] small;
    private final int[] big;
    private final FilePrinter printer;
    private final Algo[] sortingAlgos;

    public TestFactory(int repeat) {
        this.runner = new Runner(repeat);
        this.printer = new FilePrinter();
        this.repeat = repeat;
        this.results = new ArrayList<String>();
        this.small = new int[]{5, 10, 25, 50, 75, 100, 125, 150, 200, 250, 300, 400, 500};
        this.big = new int[]{500, 750, 1000, 1250, 1500, 2000, 3000, 5000, 7500, 10000};
        this.sortingAlgos = new Algo[]{new Bubblesort(), new Quicksort(), new Insertionsort(), new Selectionsort()};
    }

    /**
     * Runs tests for small size random arrays with all sorting algorithms.
     * Results will be added to arraylist, which is finally printed to text
     * file.
     */
    public void runRandomSmallArraysTestCycleForAll() {
        results.add("Random small arrays test. Test cycle repeated " + repeat + " times.");

        addAlgosToResults();

        for (int r : small) {
            addRunnerTimesToResults(new RandomNoDuplicates(r));
        }

        System.out.println("Random small arrays tests completed.");
    }

    /**
     * Runs tests for big size random arrays with all sorting algorithms.
     * Results will be added to arraylist, which is finally printed to text
     * file.
     */
    public void runRandomBigArraysTestCycleForAll() {
        results.add("Random big arrays test. Test cycle repeated " + repeat + " times.");
        addAlgosToResults();

        for (int r : big) {
            addRunnerTimesToResults(new RandomNoDuplicates(r));
        }

        System.out.println("Random big arrays tests completed.");
    }

    /**
     * Runs tests for small size sorted arrays with all sorting algorithms.
     * Results will be added to arraylist, which is finally printed to text
     * file.
     */
    public void runSortedSmallArraysTestCycleForAll() {
        results.add("Allmost sorted small arrays test. Test cycle repeated " + repeat + " times.");
        addAlgosToResults();

        for (int r : small) {
            addRunnerTimesToResults(new AllmostSorted(r));
        }

        System.out.println("Allmost sorted small arrays tests completed.");
    }

    /**
     * Runs tests for small size sorted arrays with all sorting algorithms.
     * Results will be added to arraylist, which is finally printed to text
     * file.
     */
    public void runSortedBigArraysTestCycleForAll() {
        results.add("Allmost sorted big arrays test. Test cycle repeated " + repeat + " times.");
        addAlgosToResults();

        for (int r : big) {
            addRunnerTimesToResults(new AllmostSorted(r));
        }
        System.out.println("Allmost sorted big arrays tests completed.");

    }

    /**
     * Runs tests for small size reversed arrays with all sorting algorithms.
     * Results will be added to arraylist, which is finally printed to text
     * file.
     */
    public void runReversedSmallArraysTestCycleForAll() {
        results.add("Reversed small arrays test. Test cycle repeated " + repeat + " times.");
        addAlgosToResults();

        for (int r : small) {
            addRunnerTimesToResults(new Reversed(r));
        }

        System.out.println("Reversed small arrays tests completed.");
    }

    /**
     * Runs tests for small size reversed arrays with all sorting algorithms.
     * Results will be added to arraylist, which is finally printed to text
     * file.
     */
    public void runReversedBigArraysTestCycleForAll() {
        results.add("Reversed big arrays test. Test cycle repeated " + repeat + " times.");
        addAlgosToResults();

        for (int r : big) {
            addRunnerTimesToResults(new Reversed(r));
        }

        System.out.println("Reversed big arrays tests completed.");

    }

    /**
     * Runs tests for small size Random few Uniques arrays with all sorting
     * algorithms. Results will be added to arraylist, which is finally printed
     * to text file.
     */
    public void runRandomFewUniquesSmallArraysTestCycleForAll() {
        results.add("Random few uniques small arrays test. Test cycle repeated " + repeat + " times.");
        addAlgosToResults();

        for (int r : small) {
            addRunnerTimesToResults(new RandomFewUnique(r));
        }

        System.out.println("Random few uniques small arrays tests completed.");
    }

    /**
     * Runs tests for small size Random few Uniques arrays with all sorting
     * algorithms. Results will be added to arraylist, which is finally printed
     * to text file.
     */
    public void runRandomFewUniquesBigArraysTestCycleForAll() {
        results.add("Random few uniques big arrays test. Test cycle repeated " + repeat + " times.");
        addAlgosToResults();

        for (int r : big) {
            addRunnerTimesToResults(new RandomFewUnique(r));
        }

        System.out.println("Random few uniques big arrays tests completed.");
    }

    /**
     * Adds names of sorting algorithms to results array
     */
    private void addAlgosToResults() {
        String sorts = "";
        for (Algo a : sortingAlgos) {
            sorts += ":" + a;
        }
        results.add(sorts);
    }

    /**
     * Runs given array with all sorting algorithms. Adds results to
     * results-array.
     *
     * @param array Array to sort
     */
    private void addRunnerTimesToResults(Arr array) {
        String res = "";
        for (Algo sortingAlgorithm : sortingAlgos) {
            res += ":" + runner.run(array, sortingAlgorithm);
        }
        results.add(res);
    }

    /**
     * Result Printer. Will Clean Results-array!
     */
    public void printToFileAndClean() {
        printer.printToFile("results", results);
        results.clear();
    }
}
