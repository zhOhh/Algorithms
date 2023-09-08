package main.com.zh.datastructure.priorityqueue;

import main.com.zh.datastructure.queue.Queue;

/**
 * 基于<b>无序数组</b>实现
 *
 * @param <E> 队列中元素类型 必须实现Priority接口
 */
public class PriorityQueue1<E extends Priotity> implements Queue<E> {

    Priotity[] array;
    int size;

    public PriorityQueue1(int capacity) {
        array = new Priotity[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[size] = value;
        size++;
        return true;
    }

    //返回优先级最高的索引值
    private int selectMax() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].priority() > array[max].priority()) {
                max = i;
            }
        }
        return max;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax();
        E e = (E) array[max];
        remove(max);
        return e;
    }

    private void remove(int index) {
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        size--;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax();
        return (E) array[max];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
