/**
 * @author wangyu
 * 2019/03/08 18:39
 */
public class Sort {

    /**
     * 插入排序
     *
     * @param array 参数数组
     * @return 返回值
     */
    private int[] insertSort(int[] array) {

        System.out.print("原始数组:\t");
        print(array);
        //对比n-1趟，每次把第i个数字插入到前面的n-1个有序数组中
        for (int i = 1; i < array.length; i++) {
            //key就是这一趟比较要确定位置的元素
            int key = array[i];
            //在前面i-1个有序序列中对比
            int j;
            for (j = i - 1; j >= 0 && key < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
            System.out.printf("第%d趟比较之后结果:\t", i);
            print(array);
        }
        return array;
    }

    /**
     * 冒泡排序
     *
     * @param array 排序数组
     * @return
     */
    private int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        print(array);
        return array;
    }

    /**
     * 快速排序
     *
     * @param array 排序数组
     * @param low   低地址
     * @param high  高地址
     */
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }

    }

    /**
     * 快速排序划分算法
     *
     * @param array     排序数组
     * @param lowIndex  低地址
     * @param highIndex 高地址
     * @return 基准元素的位置
     */
    private int partition(int[] array, int lowIndex, int highIndex) {
        int pivot = array[lowIndex];
        while (lowIndex < highIndex) {
            while (lowIndex < highIndex && array[highIndex] > pivot) {
                highIndex--;
            }
            array[lowIndex] = array[highIndex];

            while (lowIndex < highIndex && array[lowIndex] <= pivot) {
                lowIndex++;
            }
            array[highIndex] = array[lowIndex];
        }

        array[lowIndex] = pivot;
        return lowIndex;
    }

    private void print(int[] array) {
        for (int i : array) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] array = {2, 1, 5, 4, 0, 6, 8, 7, 3};
        sort.quickSort(array, 0, array.length - 1);
        sort.print(array);
    }
}
