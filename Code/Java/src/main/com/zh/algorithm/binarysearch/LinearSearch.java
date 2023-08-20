package main.com.zh.algorithm.binarysearch;

public class LinearSearch {
    /**
     * <h3>线性查找</h3>
     *
     * @param a      待查找的升序数组
     * @param target 待查找的目标值
     * @return <p>找到则返回索引</p>
     * <p>找不到则返回-1</p>
     */
    public static int linearSearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
