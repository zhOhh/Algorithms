package main.com.zh.datastructure.heap;

import java.util.Arrays;

/**
 * 小顶堆
 */
public class MinHeap {
    int[] array;
    int size;

    public MinHeap(int capacity) {
        this.array = new int[capacity];
    }

    public boolean isFull() {
        return size== array.length;
    }

    //建堆
    public void heapify() {
        //最后的非叶子节点 size/2-1
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }

    /**
     * 删除堆顶元素
     *
     * @return 堆顶元素
     */
    public int poll() {
        int top = array[0];
        swap(0, size - 1);
        size--;
        down(0);
        return top;
    }

    /**
     * 删除指定索引处元素
     *
     * @param index 索引
     * @return 被删除的元素
     */
    public int poll(int index) {
        int deleted = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return deleted;
    }

    /**
     * 替换堆顶元素
     *
     * @param replaced 新元素
     */
    public void replace(int replaced) {
        array[0] = replaced;
        down(0);
    }

    /**
     * 获取堆顶元素
     *
     * @return 堆顶元素
     */
    public int peek() {
        return array[0];
    }

    /**
     * 堆的尾部添加元素
     *
     * @param offered
     * @return 是否添加成功
     */
    public boolean offer(int offered) {
        if (size == array.length) {
            return false;
        }
        up(offered);
        size++;
        return true;
    }

    //将 inserted 元素上浮 ： 直至 offered 小于父元素或到堆顶
    private void up(int offered) {
        int chlid = size;
        while (chlid > 0) {
            int parent = (chlid - 1) / 2;
            if (offered < array[parent]) {
                array[chlid] = array[parent];
            } else {
                break;
            }
            chlid = parent;
        }
    }

    public MinHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    //将 parent 索引处的元素下潜：与两个孩子较大者交换，直至没孩子或孩子没他大
    private void down(int parent) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int min = parent;
        if (left < size && array[left] < array[min]) {
            min = left;
        }
        if (right < size && array[right] < array[min]) {
            min = right;
        }
        if (min != parent) { //找到更大的孩子
            swap(min, parent);
            down(min);
        }
    }

    //交换两个索引处的元素
    private void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {

        int[] array = {2, 3, 1, 7, 6, 4, 5};
        MinHeap heap = new MinHeap(array);
        System.out.println(Arrays.toString(heap.array));

        while (heap.size > 1) {
            heap.swap(0, heap.size - 1);
            heap.size--;
            heap.down(0);
        }

        System.out.println(Arrays.toString(heap.array));
    }
}



























