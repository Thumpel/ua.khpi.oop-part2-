package ua.oop.khpi.Yermakov11;

import java.io.Serializable;
import java.util.Iterator;


public class My_List<T> implements Serializable, Iterable<T>{

    private static final long serialVersionUID = 1L;
    private Memory<T> start;
    private Memory<T> tail;
    private int size;

    public int get_size()
    {
        return size;
    }

    public void add_elements(T obj)
    {
        size ++;
        Memory<T> temp = tail.prev;
        temp.next = new Memory<T>();
        tail.prev = temp.next;

        temp.next.obj = obj;
        temp.next.next = tail;
        temp.next.prev = temp;
    }

    public void delete(int number)
    {
        if(number>=size)
            return;

        Memory<T> temp = start.next;
        Memory<T> temp2 = null;

        for(int i = 0; i < number;i++) {
            temp = temp.next;
        }

        temp2 = temp.prev;
        temp2.next = temp.next;
        temp.next.prev = temp2;

        size--;
    }

    public void cls()
    {
        tail.prev = start;
        start.next = tail;
        size = 0;
    }

    public String toString() {
        String str = new String();


        for(T value : this) {


            str += value + "\n";
        }
        return str;
    }

    public T[] toArray(T[] arr)
    {
        int i=0;
        for (T t : this) {
            arr[i++] = t;
        }
        return arr;
    }


    public T get(int number) {
        if(number>=size && number<0)
            return null;

        Memory<T> temp = start.next;


        for(int i = 0; i < number;i++) {
            temp = temp.next;
        }

        return temp.obj;
    }

    public boolean null_or_not() {
        if(size!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }



    public My_List() {
        super();
        this.size = 0;
        this.start = new Memory<T>(null,tail,null);
        this.tail = new Memory<T>(null,null,start);

    }


    public My_List(Memory<T> start,Memory<T> tail, int size) {
        super();
        this.start = start;
        this.tail = tail;
        this.size = size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int itr = 0;
            @Override
            public boolean hasNext() {

                return itr < size;
            }

            @Override
            public T next() {
                return get(itr++);
            }
            @Override
            public void remove() {
                delete(itr-1);
            }
        };
    }
    public void swap(int i1, int i2) {
        if (i1 >= size && i2 >= size && i1 == i2)
            return;

        Memory<T> temp1 = start.next;
        Memory<T> temp2 = start.next;
        for (int i = 0; i < i1; i++) {
            temp1 = temp1.next;
        }

        for (int i = 0; i < i2; i++) {
            temp2 = temp2.next;
        }
        T temp = temp1.obj;
        temp1.obj = temp2.obj;
        temp2.obj = temp;

    }

}
