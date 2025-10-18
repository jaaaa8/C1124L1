// File: `TestGitHubCopilot.java`
import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestGitHubCopilot {

    // Approach 1: use a HashSet to detect duplicates while iterating
    public static boolean containsDuplicateSet(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            if (!seen.add(n)) return true; // add returns false if already present
        }
        return false;
    }

    // Approach 2: sort a copy of the array and check adjacent elements
    public static boolean containsDuplicateSort(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        for (int i = 1; i < copy.length; i++) {
            if (copy[i] == copy[i - 1]) return true;
        }
        return false;
    }

    // Three test cases runnable from main
    public static void main(String[] args) {
        int[][] tests = {
            {1, 2, 3, 1}, // true
            {1, 2, 3, 4}, // false
            {2, 2}        // true
        };

        for (int i = 0; i < tests.length; i++) {
            int[] t = tests[i];
            System.out.printf("Test %d: input=%s -> set=%b, sort=%b%n",
                i + 1, Arrays.toString(t),
                containsDuplicateSet(t), containsDuplicateSort(t));
        }
    }

    // JUnit 5 tests integrated in this class
    @Test
    public void testDuplicatePresent() {
        int[] input = {1, 2, 3, 1};
        assertTrue(containsDuplicateSet(input));
        assertTrue(containsDuplicateSort(input));
    }

    @Test
    public void testNoDuplicate() {
        int[] input = {1, 2, 3, 4};
        assertFalse(containsDuplicateSet(input));
        assertFalse(containsDuplicateSort(input));
    }

    @Test
    public void testPairDuplicate() {
        int[] input = {2, 2};
        assertTrue(containsDuplicateSet(input));
        assertTrue(containsDuplicateSort(input));
    }
}
