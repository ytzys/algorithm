package com.ytzys.algorithm.common.sort;

public class QuickSort {

    private void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivot = array[startIndex];
        int i = startIndex + 1;
        int j = endIndex;
        boolean ltr = true;
        while (i < j) {
            if (ltr) {
                if (array[i] <= pivot) {
                    array[i - 1] = array[i];
                    i++;
                } else {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                    ltr = false;
                }
            } else {
                if (array[j] >= pivot) {
                    j--;
                } else {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                    ltr = true;
                }
            }
        }
        int pos;
        if (array[i] >= pivot) {
            pos = i - 1;
            array[pos] = pivot;
        } else {
            pos = i;
            array[i - 1] = array[i];
            array[pos] = pivot;
        }
        quickSort(array, startIndex, pos - 1);
        quickSort(array, pos + 1, endIndex);
    }
}
