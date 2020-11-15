package com.example.learnspring.other;

public class ArrRemoveRepetitionTest {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 106, 2, 7, 87, 2, 4, 4, 5, 0, 34, 2, 1, 6};
        System.out.println("去重前 ：");
        printArr(arr);
        arr = intArrRmvRptt(arr);
        System.out.println("\n去重后 ：");
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int v : arr) {
            System.out.print(v + "\t");
        }
    }

    /**
     * 将数组arr去重后输出去重后的数组
     *
     * @param arr 待去重数组
     * @return 去重后的数组
     */
    private static int[] intArrRmvRptt(int[] arr) {
        if (arr == null || arr.length < 1) {
            throw new ArrayIndexOutOfBoundsException("the input array can't null or no element");
        }
        int[] b = arr;
        int nextElem = arr[0];
        for (int i = 1; i < b.length; i++) {
            int hasCnt = hasCnt(arr, nextElem, i);
            if (hasCnt > 0) {
                b = new int[arr.length - hasCnt];
                int bi = 0;//  数组b的下表
                boolean firstFLag = true;// 首次重复元素标志，即第一次出现重复元素时给b数组赋值，同时改变标志位，以后出现重复元素时不从arr数组赋值到b数组

                // 数组赋值操作，将数组arr中与 nextElem元素重复的去掉
                for (int val : arr) {
                    if (val == nextElem) {// 相等表示以存在
                        if (firstFLag) {// 判断是否是所取元素，即第一个重复元素，第一个保留；否则开始下次循环
                            b[bi] = val;
                            firstFLag = false;
                            bi++;
                        }
                    } else {// 不相等表示不是所选取待比较元素，赋值到数组b
                        b[bi] = val;
                        bi++;
                    }
                }
                //赋值结束后，将b数组赋值给arr数组，然后继续循环
                arr = b;
            }
            nextElem = arr[i];// 确定下一比较元素
        }
        return b;
    }

    /**
     * 判断一个元数element是否存在数组arr中，返回存在个数
     *
     * @param arr      待判读数组
     * @param element  需要判断数
     * @param arrStart 数组判断开始位置
     * @return 存在元素个数，0表示不存在，大于0存在
     */
    private static int hasCnt(int[] arr, int element, int arrStart) {
        int hasFlag = 0;
        for (; arrStart < arr.length; arrStart++) {
            if (element == arr[arrStart]) {
                hasFlag++;
            }
        }
        return hasFlag;
    }
}
