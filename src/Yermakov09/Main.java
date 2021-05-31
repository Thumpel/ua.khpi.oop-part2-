package ua.oop.khpi.Yermakov09;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        Employee_card employee_card=new Employee_card();
        Employee_card[] array = {new Employee_card("name 1", 1, "eduacation 1", "Date_of_appoitmant 1", "Appoimant 1", "Department 1", 90),
                new Employee_card("name 2", 2, "eduacation 2", "Data_of_appoitmant 2", "Appoimant 2", "Department 1", 90),
                new Employee_card("name 3", 3, "eduacation 3", "Data_of_appoitmant 3", "Appoimant 3", "Department 1", 90)};
        System.out.println(Arrays.toString(array));
        System.out.println("_________________");

        Container<Employee_card> container = new Container<>(10);
        for (Employee_card ec : array)
        {
            container.add(ec);
        }
        System.out.println(container);
        for (Employee_card ec : container)
        {
            if(ec!=null)
                System.out.printf(String.valueOf(ec));
        }
        try {
            Container<Employee_card> employee_cards = new Container<Employee_card>();

            employee_cards.add(new Employee_card("name 1", 1, "eduacation 1", "Date_of_appoitmant 1", "Appoimant 1", "Department 1", 90));
            employee_cards.add(new Employee_card("name 2", 2, "eduacation 2", "Date_of_appoitmant 2", "Appoimant 2", "Department 2", 90));
            employee_cards.add(new Employee_card("name 3", 3, "eduacation 3", "Date_of_appoitmant 3", "Appoimant 3", "Department 3", 90));
            Helper.serialize(employee_cards, "filename.txt");
            Container<Employee_card> newArray = Helper.Deserialize("filename.txt");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
