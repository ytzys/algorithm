package com.ytzys.algorithm.common.sort;

public class MergeSort {

    private void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int tmp = start + (end - start) / 2;
        mergeSort(array, start, tmp);
        mergeSort(array, tmp + 1, end);
        int[] tmpArray = new int[end - start + 1];
        int index1 = start;
        int index2 = tmp + 1;
        int i = 0;
        while (i <= end - start) {
            if (index2 > end || array[index1] <= array[index2]) {
                tmpArray[i] = array[index1];
                index1++;
            } else
//                if (array[index1] > array[index2])
            {
                tmpArray[i] = array[index2];
                index2++;
            }
            i++;
        }
//        while (index1 <= tmp && index2 <= end) {
//            if (array[index1] <= array[index2]) {
//                tmpArray[i] = array[index1];
//                index1++;
//            } else {
//                tmpArray[i] = array[index2];
//                index2++;
//            }
//            i++;
//        }
//        if (index1 > tmp) {
//            while (index2 <= end) {
//                tmpArray[i] = array[index2];
//                i++;
//                index2++;
//            }
//        } else {
//            while (index1 <= tmp) {
//                tmpArray[i] = array[index1];
//                i++;
//                index1++;
//            }
//        }
        i = 0;
        int index = start;
        while (index <= end) {
            array[index] = tmpArray[i];
            i++;
            index++;
        }

    }
}
