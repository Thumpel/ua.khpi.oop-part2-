package ua.oop.khpi.Yermakov11;

import java.io.Serializable;
public class Memory<T> implements Serializable {

    public T obj;
    public Memory<T> next;
    public Memory<T> prev;

    public Memory() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Memory(T obj, Memory<T> next, Memory<T> prev) {
        super();
        this.obj = obj;
        this.next = next;
        this.prev = prev;
    }


}