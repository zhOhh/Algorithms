package main.com.zh.datastructure.priorityqueue;

import main.com.zh.datastructure.queue.Queue;

/**
 * 基于<b>有序数组</b>实现
 *
 * @param <E> 队列中元素类型 必须实现Priority接口
 */
public class PriorityQueue2<E extends Priotity> implements Queue<E> {

    Priotity[] array;
    int size;

    public PriorityQueue2(int capacity) {
        array = new Priotity[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        insert(value);
        size++;
        return true;
    }

    private void insert(E value) {
        int i = size - 1;
        while (i >= 0 && array[i].priority() > value.priority()) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = value;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E e = (E) array[size - 1];
        array[--size] = null;
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[size - 1];
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
