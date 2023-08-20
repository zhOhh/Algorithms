package main.com.zh.algorithm.binarysearch;

public class BinarySearch {
    /**
     * <h3>二分查找基础版</h3>
     *
     * <ol>
     *     <li>i,j,m指针都可能是查找目标</li>
     *     <li>i>j时表示区域内没有要查找的了</li>
     *     <li>每次改变i,j,m边界时,m已经比较过不是目标,因此 m+1 m-1</li>
     *     <li>向左查找,比较次数较少,向右查找,比较次数较多</li>
     * </ol>
     *
     * @param a      待查找的升序数组
     * @param target 待查找的目标值
     * @return <p>找到则返回索引</p>
     * <p>找不到则返回-1</p>
     */
    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1;  //设置指针和初值
        while (i <= j) {  //i~j内有值
            int m = (i + j) >>> 1;
            if (target < a[m]) {  //目标在左边
                j = m - 1;
            } else if (a[m] < target) {  //目标在右边
                i = m + 1;
            } else {  //找到目标值
                return m;
            }
        }
        return -1;
    }
    /**
     *问题1: 为什么是 i<=j 意味着区间内有未比较的元素, 而不是 i<j ?
     *            i==j 意味着 i,j 它们指向的元素也会参与比较
     *            i<j 只意味着 m 指向的元素参与比较
     *
     *问题2: (i + j) / 2 有没有问题?
     *问题3: 都写成小于号有啥好处?
     */


    /**
     * <h3>二分查找改动版</h3>
     *
     * @param a      待查找的升序数组
     * @param target 待查找的目标值
     * @return <p>找到则返回索引</p>
     * <p>找不到则返回-1</p>
     */
    public static int binarySearchAlternative(int[] a, int target) {
        int i = 0, j = a.length;            //第一处
        while (i < j) {                     //第二处
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;                      //第三处
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }


}
