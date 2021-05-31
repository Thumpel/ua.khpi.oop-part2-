package ua.oop.khpi.Yermakov15;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class My_List<T> implements Serializable{


    ArrayList<T> list;

    public int get_size()
    {
        return list.size();
    }

    public void add_elements(T obj)
    {
        list.add(obj);
    }

    public void delete(int number)
    {
        if(number>=list.size())
            return;
        list.remove(number);
    }

    public void cls()
    {
        list.clear();
    }

    public String toString() {

        return list.toString();
    }

    public T[] toArray()
    {
        return (T[]) list.toArray();
    }


    public T get(int number) {
        if(number>=list.size() && number<0)
            return null;
        return list.get(number);
    }

    public boolean null_or_not() {
        return list.isEmpty();
    }


    public void sort(Comparator<T> parametr) {
        list.sort(parametr);
    }

}