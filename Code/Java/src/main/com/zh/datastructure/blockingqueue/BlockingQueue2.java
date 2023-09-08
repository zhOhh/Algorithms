package main.com.zh.datastructure.blockingqueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 双锁实现
 *
 * @param <E> 元素类型
 */
public class BlockingQueue2<E> implements BlockingQueue<E> {


    private final E[] array;
    private int head;
    private int tail;
    private int size;

    private ReentrantLock tailLock = new ReentrantLock();
    private Condition tailWait = tailLock.newCondition();

    private ReentrantLock headLock = new ReentrantLock();
    private Condition headWait = tailLock.newCondition();

    public BlockingQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }

    private ReentrantLock lock = new ReentrantLock();
    private Condition headWaits = lock.newCondition();
    private Condition tailWaits = lock.newCondition();

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public void offer(E e) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            //1.队列满则等待
            while (isFull()) {
                tailWaits.await();
            }

            //2.不满则入队
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }

            //3.修改 size
            size++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            long t= TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isFull()) {
                if (t<=0) {
                    return false;
                }
                t=tailWaits.awaitNanos(t);
            }
            array[tail] = e;
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E poll() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            //1.队列空则等待
            while (isEmpty()) {
                headWaits.await();
            }

            //2.非空则出队
            E e = array[head];
            array[head] = null;
            if (++head == array.length) {
                head = 0;
            }

            //3.修改 size
            size--;

            return e;
        } finally {
            lock.unlock();
        }
    }
}
