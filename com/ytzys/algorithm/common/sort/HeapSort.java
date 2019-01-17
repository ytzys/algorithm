package com.ytzys.algorithm.common.sort;

public class HeapSort {

    private void heapSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int parent = (i - 1) / 2;
            if (array[i] > array[parent]) {
                int tmp = array[parent];
                array[parent] = array[i];
                array[i] = tmp;
            }
        }
        for (int i = array.length - 1; i > 0; i--) {
            int tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;
            heapSortAdjust(array, i - 1);
        }
    }

    private void heapSortAdjust(int[] array, int lastIndex) {
        int index = 0;
        while (index < lastIndex) {
            int leftChild = index * 2 + 1;
            if (leftChild > lastIndex) {
                break;
            }
            int max;
            int rightChild = index * 2 + 2;
//            if (rightChild <= lastIndex) {
//                if (array[leftChild] >= array[rightChild]) {
//                    max = leftChild;
//                } else {
//                    max = rightChild;
//                }
//            } else {
//                if (array[index] >= array[leftChild]) {
//                    break;
//                } else {
//                    max = leftChild;
//                }
//            }
            if (rightChild <= lastIndex && array[leftChild] < array[rightChild]) {
                max = rightChild;
            } else {
                max = leftChild;
            }
            if (array[index] < array[max]) {
                int tmp = array[max];
                array[max] = array[index];
                array[index] = tmp;
                index = max;
            } else {
                break;
            }

        }
    }
}
