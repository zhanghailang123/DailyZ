package com.zhanghl.first.reduceif;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/
 */
public class QuickSort3 {

    /**
     * 快速排序
     * @param nums
     * @param L
     * @param R
     */
    public void solution(int[] nums, int L, int R) {
        int i = L;
        int j = R;
        int pivot = nums[(L + R) / 2];

        while (i <= j) {

            while (pivot > nums[i]) {
                i ++ ;

            }

            while (pivot < nums[j]) {
                j --;
            }

            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i ++ ;
                j --;
            }
        }
    }


    public static int findKthLargest(int[] nums, int k) {

        sort(0,nums.length - 1, nums);
        return nums[k-1];
    }

    private static void sort(int l, int r, int[] nums) {
        int i = l, j = r, x = nums[l];
        if (l < r) {
            while (i < j) {

                while (i < j && nums[j] < x) {
                    j--;
                }
                if (i < j) {
                    nums[i] = nums[j];
                    i++;

                }

                while (i < j && nums[i] >= x) {
                    i++;
                }
                if ( i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = x;
            if (l < i - 1) {
                sort(l, i - 1, nums);
            }
            if (i + 1 < r) {
                sort(i + 1, r, nums);
            }

        }


    }
    public static void quickSort(int[] arr, int L, int R) {
        int i = L;
        int j = R;
        //⽀点
        int pivot = arr[(L + R) / 2];
        //左右两端进⾏扫描，只要两端还没有交替，就⼀直扫描
        while (i <= j) {
            //寻找直到⽐⽀点⼤的数
            while (pivot > arr[i])
                i++;
            //寻找直到⽐⽀点⼩的数
            while (pivot < arr[j])
                j--;
            //此时已经分别找到了⽐⽀点⼩的数(右边)、⽐⽀点⼤的数(左边)，它们进⾏交换
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        //上⾯⼀个while保证了第⼀趟排序⽀点的左边⽐⽀点⼩，⽀点的右边⽐⽀点⼤了。

        //“左边”再做排序，直到左边剩下⼀个数(递归出⼝)
        if (L < j)
            quickSort(arr, L, j);
        //“右边”再做排序，直到右边剩下⼀个数(递归出⼝)
        if (i < R)
            quickSort(arr, i, R);
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        System.out.println(findKthLargest(arr, 2));
//
//        sort0723(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(a -> System.out.println(a));
//
//        quick_sort(arr, 0, arr.length-1);
//        Arrays.stream(arr).forEach(a -> System.out.println(a));
    }



    public static void sort0723(int[] nums, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = nums[l];

            while (i < j) {

                while (i < j && nums[j] > x) {
                    j--;
                }
                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }


                while (i < j && nums[i] <= x) {
                    i++;
                }

                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }


            }
            nums[i] = x;


            sort0723(nums, l, i - 1);
            sort0723(nums, i + 1, r);
        }

    }






















    static void quick_sort(int s[], int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }
}
