package ua.oop.khpi.Yermakov12;

import java.util.Comparator;

public class Helper {


    static <T extends HumanResourcesDepartment> void sort(My_List<T> collection, ESort choose) {
        boolean przEnd = true;
        while (przEnd) {
            przEnd = false;
            for (int i = 0; i < collection.get_size() - 1; i++) {
                switch (choose) {
                    case PASSPORT_ID:{
                        if (collection.get(i).getPassport_ID().compareTo(collection.get(i + 1).getPassport_ID()) > 0) {
                            collection.swap(i, i + 1);
                            przEnd = true;
                        }
                        break;}
                    case PASSPORT_SERIES:{
                        if (collection.get(i).getPassport_series().compareTo(collection.get(i + 1).getPassport_series()) > 0) {
                            collection.swap(i, i + 1);
                            przEnd = true;
                        }
                        break;}
                    case SALARY:{
                        Comparator<HumanResourcesDepartment> comparator_salary = (a,b) -> (a.getSalary() < b.getSalary()) ? -1 : ((a.getSalary() == b.getSalary()) ? 0 : 1);
                        HumanResourcesDepartment el1 =  collection.get(i);
                        HumanResourcesDepartment el2 =  collection.get(i+1);

                        if(el1.equals(el2))
                        {
                            collection.swap(i, i + 1);
                            przEnd = true;
                        }
                        break;
                    }
                    case RATING:{
                        if (collection.get(i).getAverage_ratting().compareTo(collection.get(i + 1).getAverage_ratting()) > 0) {
                            collection.swap(i, i + 1);
                            przEnd = true;
                        }
                        break; }
                    default:
                        break;
                }
            }
        }
    }


    public Helper() {
        // TODO Auto-generated constructor stub
    }
    enum ESort {
        PASSPORT_ID,
        PASSPORT_SERIES,
        SALARY,
        RATING
    }
}
