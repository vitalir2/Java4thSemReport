package task3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SetSemaphore<T> implements Set<T> {

    private static final Semaphore semaphore = new Semaphore(1);
    private final Set<T> innerSet = new HashSet<>();

    @Override
    public int size() {
        return innerSet.size();
    }

    @Override
    public boolean isEmpty() {
        return innerSet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return innerSet.contains(o);
    }

    @Override
    public Iterator iterator() {
        return innerSet.iterator();
    }

    @Override
    public Object[] toArray() {
        return innerSet.toArray();
    }

    @Override
    public boolean add(Object o) {
        try {
            semaphore.acquire();
            boolean result =  innerSet.add((T) o);
            semaphore.release();
            return result;
        } catch (InterruptedException ex) {
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            semaphore.acquire();
            boolean result =  innerSet.remove((T) o);
            semaphore.release();
            return result;
        } catch (InterruptedException ex) {
            return false;
        }
    }

    @Override
    public boolean addAll(Collection collection) {
        try {
            semaphore.acquire();
            boolean result =  innerSet.addAll(collection);
            semaphore.release();
            return result;
        } catch (InterruptedException ex) {
            return false;
        }
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            innerSet.clear();
            semaphore.release();
        } catch (InterruptedException ex) {
            // Do nothing.. Alright!
        }
    }

    @Override
    public boolean removeAll(Collection collection) {
        try {
            semaphore.acquire();
            boolean result =  innerSet.removeAll(collection);
            semaphore.release();
            return result;
        } catch (InterruptedException ex) {
            return false;
        }
    }

    @Override
    public boolean retainAll(Collection collection) {
        try {
            semaphore.acquire();
            boolean result =  innerSet.retainAll(collection);
            semaphore.release();
            return result;
        } catch (InterruptedException ex) {
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection collection) {
        return innerSet.containsAll(collection);
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return innerSet.toArray();
    }
}
