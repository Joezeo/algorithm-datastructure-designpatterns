package com.joezeo.collections;

import java.util.*;


/**
 * 个人简单实现ArrayList部分主体功能
 * ArrayList实现List接口
 * 底层数据存储实际用的是数组
 * 我们知道，数组的长度是固定的
 * 所以ArrayList实现的要点就在于自动扩容机制的实现
 *
 * @param <E>
 */
public class ArrayList_s<E> implements List<E> {

    // ArrayList默认初始化长度
    private static final int LIST_DEFAULT_INITIAL_SIZE = 10;

    // ArrayList当前最大长度
    private int currentMaxSize;

    // ArrayList当前存储数据长度
    private int size;

    // 用于存储数据的主要容器
    private Object[] data;

    // 构造方法
    public ArrayList_s(){
        data = new Object[LIST_DEFAULT_INITIAL_SIZE];
        currentMaxSize = LIST_DEFAULT_INITIAL_SIZE;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    /*
    这两个private函数是ArrayList容量自动增长的关键
    当容量满时，创建一个长度是原先长度1.5倍的新数组
    再把数据拷贝过去
     */
    private void ensureCapacity(int curSize){
        if(curSize > currentMaxSize){
            grow(curSize);
        }
    }
    private void grow(int curSize){
        // 扩展为原来的1.5倍
        int newSize = currentMaxSize + (currentMaxSize >> 1);

        // 如果扩展了1.5倍还不符合要求 直接设为需要的值
        if(newSize - curSize < 0)
            newSize = curSize;

        currentMaxSize = newSize;

        data = Arrays.copyOf(data, currentMaxSize);
    }

    @Override
    public boolean add(E e) {
        ensureCapacity(size+1);
        data[size++] = e;
        // ArrayList本身的存储过程于此类似 可以看出ArrayList是线程不安全的
        return true;
    }

    @Override
    public void clear() {
        data = new Object[LIST_DEFAULT_INITIAL_SIZE];
        currentMaxSize = LIST_DEFAULT_INITIAL_SIZE;
        size = 0;
    }

    //边界检查
    private void rangeCheck(int index){
        if(index<0 || index>=size){
            throw new RuntimeException("ArrayOutOfBound: index="+index);
        }
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E)data[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E oldValue = get(index);
        data[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
