package seminars.sem2;

import javax.xml.crypto.Data;
import java.util.Date;

public class Main {
    public static void SSort(int[] arr){
        for(int i=0; i < arr.length / 2; i++){
            for(int j = i; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    //swap(arr[j], arr[j+1]);
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            for(int j = arr.length - i - 1; j > i; j--){
                if(arr[j] < arr[j - 1]){
                    //swap(arr[j], arr[j - 1]);
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    static int[] buf = new int[100000];
    public static void MergeSort(int[] arr) {
        MergeSort(arr, 0, arr.length - 1);
    }

    public static void MergeSort(int[] arr, int left, int right) {
        if(left == right){
            return ;
        }

        int mid = (left + right) / 2;
        MergeSort(arr, left, mid);
        MergeSort(arr, mid + 1, right);

        int i = left, j = mid + 1, k = left;

        while(i <= mid && j <= right){
            if(arr[i] < arr[j]){
                buf[k++] = arr[i++];
            }else{
                buf[k++] = arr[j++];
            }
        }

        while(i <= mid){
            buf[k++] = arr[i++];
        }

        while(j <= right){
            buf[k++] = arr[j++];
        }

        for(int q = left; q<=right; q++)
            arr[q] = buf[q];
    }

    public static void Test(){
        int n = 50000;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for(int i=0; i<n; i++){
            int num = (int) (Math.random() * 1000);
            arr1[i] = num;
            arr2[i] = num;
        }

        Date start = new Date();
        SSort(arr1);
        Date end = new Date();
        long time1 = end.getTime() - start.getTime();

        start = new Date();
        MergeSort(arr2);
        end = new Date();
        long time2 = end.getTime() - start.getTime();

        System.out.printf("time1 = %d, time2 = %d", time1, time2);

    }

    public static int BinarySearch(int[] arr, int value){
        int left = 0, right = arr.length - 1;
        while(right - left > 1){
            int mid = (left + right) / 2;
            if(arr[mid] < value)
                left = mid;
            else
                right = mid;
        }
        if(arr[left] == value)
            return left;
        if(arr[right] == value)
            return right;
        return -1;
    }

    public static void main(String[] args) {
//        int[] arr = new int[100];
//        for(int i=1; i<=100; i++){
//            arr[100-i] = i;
//        }
//        MergeSort(arr);
//
//        for(int i : arr)
//            System.out.printf("%d ", i);
//        System.out.println();

        //Test();

        int n = 10;
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++)
            arr1[i] = (int) (Math.random() * 5);

        MergeSort(arr1);

        for(int i=0; i<n; i++)
            System.out.printf("%d ", arr1[i]);
        System.out.println();

        System.out.println(BinarySearch(arr1, 3));
    }
}