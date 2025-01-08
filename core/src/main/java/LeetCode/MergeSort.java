package LeetCode;

import java.util.Arrays;

/**
 * @description: 归并排序的解法
 * @author: zhanghailang
 * @date: 2021-5-11 13:17
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,4,1,7,2,9,11,4,44};
        sort(arr);
        System.out.println("结果为 ：" + Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int[] temp = new int[arr.length];
        sort(arr,0,arr.length -1,temp);
    }
    public static void sort(int[] arr,int left,int right,int[] temp){
        if (left < right){

            int mid = (left + right) / 2;
            //左边归并排序，使得左子序列有序
            sort(arr,left,mid,temp);
            //右边归并排序，使得右子序列有序
            sort(arr,mid + 1,right,temp);
            mergeSort(arr,left,mid,right,temp);
        }
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        for (int i = left; i < right; i ++){
//            temp = arr[i]
            temp[i + 1] = arr[i + 1];
            if (arr[i] > arr[i + 1]){
                arr[i + 1] = arr[i];
                arr[i] = temp[i + 1];
            }
        }
    }

    /**
     * 正确的归并操作
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid){
            temp[t++] = arr[i++];
        }
        while (j <= right){
            temp[t++] = arr[j++];
        }
        t = 0;
        while (left <= right){
            arr[left++] = temp[t++];
        }
    }
}