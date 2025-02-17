package lesson_4_class_and_object.bai_tap.bt_2;

import java.util.Random;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }
    public void stop() {
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int minIndex;
        for (int i = 0; i < n - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        int size = 100000;
        int[] array = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt(100000);
        }
        sw.start();
        selectionSort(array);
        sw.stop();
        System.out.println("Thời gian thực thi của thuật toán Selection Sort với 100,000 phần tử là "+sw.getElapsedTime()+" miliseconds");
    }
}
