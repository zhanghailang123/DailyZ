package fromtoday;

/**
 * @description: 分治思想加双指针解决快速排序
 * @author: zhanghailang
 * @date: 2020/11/1 0001 16:50
 */
import java.util.Arrays;

public class QuickSortSolution {
    public static void main(String[] args) {
        quickSort(new int[]{39,28,55,87,66,3,17,39});
    }

    public static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int left,int right){
        int middle;
        if(left < right){
            middle = partition(arr,left,right);
            quickSort(arr,left,middle-1);
            quickSort(arr,middle+1,right);
        }
    }

    public static int partition(int[] arr,int left,int right){
        int pivot = arr[left];
        while(left < right){
            while(left<right && arr[right] >= pivot)
                right--;
            arr[left] = arr[right];
            while(left < right && arr[left]<= pivot)
                left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }


    public static int solution(int[] arr, int left,int right){
        int privot = arr[left];
        while (left < right){
            while (left < right && arr[right] >= privot){
                right--;
                arr[left] = arr[right];
            }
            while (left < right && arr[left] <= privot){
                left ++;
                arr[right] = arr[left];
            }
        }
        arr[left] = privot;
        return left;
    }


}