package task3;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ListWithLock<T> implements List<T> {

    private final static Lock lock = new ReentrantLock();
    private final List<T> innerList = new ArrayList<>();

    @Override
    public int size() {
        return innerList.size();
    }

    @Override
    public boolean isEmpty() {
        return innerList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return innerList.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return innerList.iterator();
    }

    @Override
    public Object[] toArray() {
        return innerList.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return innerList.toArray(t1s);
    }

    @Override
    public boolean add(T t) {
        lock.lock();
        boolean result = innerList.add(t);
        lock.unlock();
        return result;
    }

    @Override
    public boolean remove(Object o) {
        lock.lock();
        boolean result = innerList.remove(o);
        lock.unlock();
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return innerList.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        lock.lock();
        boolean result = innerList.addAll(collection);
        lock.unlock();
        return result;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        lock.lock();
        boolean result = innerList.addAll(i, collection);
        lock.unlock();
        return result;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        lock.lock();
        boolean result = innerList.removeAll(collection);
        lock.unlock();
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        lock.lock();
        boolean result = innerList.retainAll(collection);
        lock.unlock();
        return result;
    }

    @Override
    public void clear() {
        lock.lock();
        innerList.clear();
        lock.unlock();
    }

    @Override
    public T get(int i) {
        return innerList.get(i);
    }

    @Override
    public T set(int i, T t) {
        lock.lock();
        T result = innerList.set(i, t);
        lock.unlock();
        return result;
    }

    @Override
    public void add(int i, T t) {
        lock.lock();
        innerList.add(i, t);
        lock.unlock();
    }

    @Override
    public T remove(int i) {
        lock.lock();
        T result = innerList.remove(i);
        lock.unlock();
        return result;
    }

    @Override
    public int indexOf(Object o) {
        return innerList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return innerList.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return innerList.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        return innerList.listIterator(i);
    }

    @Override
    public List<T> subList(int i, int i1) {
        return innerList.subList(i, i1);
    }
}
