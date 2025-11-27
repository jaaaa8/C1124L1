
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TestGitHubCopilot2 {

    // Sorts the array in ascending order using selection sort (in-place).
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
            }
        }
    }

    // Sorts the array in ascending order using merge sort (O(n log n)).
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, tmp, left, mid);
        mergeSort(arr, tmp, mid + 1, right);
        merge(arr, tmp, left, mid, right);
    }

    private static void merge(int[] arr, int[] tmp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= right) tmp[k++] = arr[j++];
        for (k = left; k <= right; k++) arr[k] = tmp[k];
    }

    // Radix sort (LSD) for 32-bit ints: 4 passes of 8 bits (base 256).
    // Uses stable counting sort per byte. For the most significant byte
    // XOR with 0x80 to correctly order negative numbers.
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        final int RADIX = 256;
        int[] aux = new int[arr.length];

        for (int shift = 0; shift < 32; shift += 8) {
            int[] count = new int[RADIX];
            int bias = (shift == 24) ? 0x80 : 0;

            // count keys (possibly XORed for sign handling on top byte)
            for (int v : arr) {
                int key = ((v >>> shift) & 0xFF) ^ bias;
                count[key]++;
            }
            // accumulate
            for (int i = 1; i < RADIX; i++) count[i] += count[i - 1];
            // place in aux stable from right to left
            for (int i = arr.length - 1; i >= 0; i--) {
                int key = ((arr[i] >>> shift) & 0xFF) ^ bias;
                aux[--count[key]] = arr[i];
            }
            // copy back
            System.arraycopy(aux, 0, arr, 0, arr.length);
        }
    }

    // Main method to test selectionSort, mergeSort and radixSort with a few cases.
    public static void main(String[] args) {
        int[][] tests = {
                {64, 25, 12, 22, 11},
                {5, 4, 3, 2, 1},
                {1, 2, 3, 4, 5},
                {-5, 3, -1, 0, 2}
        };

        for (int i = 0; i < tests.length; i++) {
            int[] original = tests[i];
            int[] a = Arrays.copyOf(original, original.length);
            int[] b = Arrays.copyOf(original, original.length);
            int[] c = Arrays.copyOf(original, original.length);

            System.out.printf("Test %d before: %s%n", i + 1, Arrays.toString(original));

            selectionSort(a);
            System.out.printf(" after selectionSort : %s%n", Arrays.toString(a));

            mergeSort(b);
            System.out.printf(" after mergeSort     : %s%n", Arrays.toString(b));

            radixSort(c);
            System.out.printf(" after radixSort     : %s%n%n", Arrays.toString(c));
        }
    }

    // Kiểm tra mảng đã được sắp xếp trước: các hàm sort không thay đổi thứ tự
    @Test
    void testAlreadySorted() {
        int[] original = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        // selectionSort giữ nguyên thứ tự
        int[] a = Arrays.copyOf(original, original.length);
        TestGitHubCopilot2.selectionSort(a);
        assertArrayEquals(expected, a);

        // mergeSort giữ nguyên thứ tự
        int[] b = Arrays.copyOf(original, original.length);
        TestGitHubCopilot2.mergeSort(b);
        assertArrayEquals(expected, b);

        // radixSort giữ nguyên thứ tự
        int[] c = Arrays.copyOf(original, original.length);
        TestGitHubCopilot2.radixSort(c);
        assertArrayEquals(expected, c);
    }

    // Kiểm tra mảng sắp giảm dần: các hàm sort phải trả về mảng tăng dần
    @Test
    void testReverseSorted() {
        int[] original = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        int[] a = Arrays.copyOf(original, original.length);
        TestGitHubCopilot2.selectionSort(a);
        assertArrayEquals(expected, a);

        int[] b = Arrays.copyOf(original, original.length);
        TestGitHubCopilot2.mergeSort(b);
        assertArrayEquals(expected, b);

        int[] c = Arrays.copyOf(original, original.length);
        TestGitHubCopilot2.radixSort(c);
        assertArrayEquals(expected, c);
    }

    // Kiểm tra mảng có số âm và dương: đảm bảo các hàm xử lý dấu đúng
    @Test
    void testWithNegatives() {
        int[] original = {-5, 3, -1, 0, 2};
        int[] expected = {-5, -1, 0, 2, 3};

        int[] a = Arrays.copyOf(original, original.length);
        TestGitHubCopilot2.selectionSort(a);
        assertArrayEquals(expected, a);

        int[] b = Arrays.copyOf(original, original.length);
        TestGitHubCopilot2.mergeSort(b);
        assertArrayEquals(expected, b);

        int[] c = Arrays.copyOf(original, original.length);
        TestGitHubCopilot2.radixSort(c);
        assertArrayEquals(expected, c);
    }

    // Kiểm tra mảng có phần tử trùng lặp: đảm bảo thứ tự và số lượng đúng
    @Test
    void testWithDuplicates() {
        int[] original = {2, 5, 3, 2, 1, 5};
        int[] expected = {1, 2, 2, 3, 5, 5};

        int[] a = Arrays.copyOf(original, original.length);
        TestGitHubCopilot2.selectionSort(a);
        assertArrayEquals(expected, a);

        int[] b = Arrays.copyOf(original, original.length);
        TestGitHubCopilot2.mergeSort(b);
        assertArrayEquals(expected, b);

        int[] c = Arrays.copyOf(original, original.length);
        TestGitHubCopilot2.radixSort(c);
        assertArrayEquals(expected, c);
    }

    // Kiểm tra mảng rỗng và null: không ném ngoại lệ và trả về mảng rỗng như ban đầu
    @Test
    void testEmptyAndNull() {
        int[] empty = {};

        // empty array: kết quả vẫn rỗng
        int[] emptyA = Arrays.copyOf(empty, empty.length);
        TestGitHubCopilot2.selectionSort(emptyA);
        assertArrayEquals(empty, emptyA);

        int[] emptyB = Arrays.copyOf(empty, empty.length);
        TestGitHubCopilot2.mergeSort(emptyB);
        assertArrayEquals(empty, emptyB);

        int[] emptyC = Arrays.copyOf(empty, empty.length);
        TestGitHubCopilot2.radixSort(emptyC);
        assertArrayEquals(empty, emptyC);

        // null: chỉ kiểm tra không ném ngoại lệ khi truyền null
        assertDoesNotThrow(() -> TestGitHubCopilot2.selectionSort(null));
        assertDoesNotThrow(() -> TestGitHubCopilot2.mergeSort(null));
        assertDoesNotThrow(() -> TestGitHubCopilot2.radixSort(null));
    }
}

