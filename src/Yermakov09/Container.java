package ua.oop.khpi.Yermakov09;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Container<E>implements Iterable<E>{
    private E[] array;
   public Container(int size)
        {

            this.array= (E[]) new Object[size];
        }

    public Container()
        {
            this.array= (E[]) new Object[0];
        }

        public void add(E data) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = data;
    }

        public <T> T[] toArray() {
        return (T[])
                Arrays.copyOf(array, array.length + 1);
    }


        public String toString() {
        StringBuilder buf = new StringBuilder();
        for (Object object : array) {
            if(object!=null)
                buf.append(object).append(System.lineSeparator());
        }
        return buf.toString();
    }

        void sort(Comparator<? super E> c) {
        E[] a = this.toArray();
        Arrays.sort(a, c);
    }

        @Override
        public Iterator<E> iterator() {
        return new MyIterator(array);
    }




    class MyIterator implements Iterator<E>
        {
            int current= 0;
            public E[]arr;
            public MyIterator(E[] arr)
            {
                this.arr=arr;
            }


            @Override
            public boolean hasNext() {

                return arr.length > current;
            }

            @Override
            public E next() {

                return arr[current++];
            }
        }

    }

