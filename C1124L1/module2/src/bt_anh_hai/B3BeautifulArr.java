package bt_anh_hai;

public class B3BeautifulArr {
    public static boolean beautifulArr(int[] arr) {
        int sumStart = arr[0];
        int totalSum = sumArr(arr);
        int sumEnd;
        for (int i = 1; i < arr.length; i++) {
            sumEnd = totalSum-(sumStart + arr[i]);
            if(sumStart == sumEnd) {
                return true;
            }
            sumStart += arr[i];
        }
        return false;
    }
    public static int sumArr(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 9};
        System.out.println(beautifulArr(arr));
    }
}
