package com.zhanghl.first.reduceif;

import java.util.Arrays;

/**
 * @author hailang.zhang
 * @since 2023-05-23
 */
public class QuickSort4 {
    public static void main(String[] args) {
        QuickSort4 quickSort4 = new QuickSort4();
        int[] arr = {3,2,1,5,6,4};
        System.out.println(quickSort4.findKthLargest(arr, 2));
        //
        //        sort0723(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(a -> System.out.println(a));
        //
        //        quick_sort(arr, 0, arr.length-1);
        //        Arrays.stream(arr).forEach(a -> System.out.println(a));
    }


    public int findKthLargest(int[] nums, int k) {
        quickSort2(nums,0, nums.length-1);
        return nums[nums.length-k];
    }

    public void quickSort2(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int key = a[l];
        int i = l, j = r;
        while (i < j) {
            while (i < j && a[j] >= key) {
                j--;
            }
            while (i < j && a[i] <= key) {
                i ++;
            }

            if (i < j)  {
                swap(a , i , j);
            }


        }
        swap(a, i, l);
        quickSort2(a, l, i - 1);
        quickSort2(a, j + 1, r);
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}