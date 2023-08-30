package main.com.zh.datastructure.stack;

public interface Stack<E> {

    /**
     * 像栈顶压入元素
     * @param value 带压入值
     * @return 压入成功返回true，否则返回false
     */
    boolean push(E value);

    /**
     * 从栈顶弹出元素
     * @return 栈非空返回栈顶元素，栈为空返回null
     */
    E pop();

    /**
     * 返回栈顶元素，不弹出
     * @return 栈非空返回栈顶元素，栈为空返回null
     */
    E peek();

    /**
     * 判断栈是否为空
     * @return 空返回true，否则返回false
     */
    boolean isEmpty();

    /**
     * 判断栈是否已满
     * @return 满返回true，否则返回false
     */
    boolean isFull();

}
