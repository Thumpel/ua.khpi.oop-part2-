package ua.oop.khpi.Yermakov09;

import java.util.Map;

public class Employee_card
{
    String name;//Имя сотрудника
    int id_pass;//id паспорта
    String education;//Образование
    String Date_of_appointment;//Дата назначение
    String Appointment;//Назначение
    String Department;//Отдел
    int set_of_properties_and_ratings;//Набор оценок

    public Employee_card(String name, int id_pass, String education, String Date_of_appointment, String Appointment, String Department, int set_of_properties_and_ratings)
    {
        this.name=name;
        this.id_pass=id_pass;
        this.education=education;
        this.Date_of_appointment=  Date_of_appointment;
        this.Appointment=Appointment;
        this.Department=Department;
        this.set_of_properties_and_ratings=set_of_properties_and_ratings;
    }

    public Employee_card() {

    }

    public String getName()
    {

        return name;
    }
    public String getEducation()
    {

        return education;
    }
    public String getAppointment()
    {

        return Appointment;
    }
    public String getDepartment()
    {

        return Department;
    }
    public int getSet_of_properties_and_ratings()
    {

        return set_of_properties_and_ratings;
    }
    public int getId_pass()
    {

        return id_pass;
    }
    public String getDate_of_appointment()
    {

        return Date_of_appointment;
    }
    public void setName(String name)
    {

        this.name=name;
    }
    public void setEducation(String education)
    {

        this.education=education;
    }
    public void setId_pass(int id_pass)
    {

        this.id_pass=id_pass;
    }
    public void setDate_of_appointment(String date_of_appointment)
    {

        this.Date_of_appointment=date_of_appointment;
    }
    public void setAppointment(String appointment)
    {

        this.Appointment=appointment;
    }
    public void setDepartment(String department)
    {

        this.Department=department;
    }
    public void setSet_of_properties_and_ratings(int set_of_properties_and_ratings)
    {
        this.set_of_properties_and_ratings=set_of_properties_and_ratings;
    }
    @Override
    public String toString()
    {
        return "Employee_card{"+" name "+name+
                " id_pass "+id_pass+
                " education "+education+
                " Date_of_appoitmant "+Date_of_appointment+
                " Appoimant "+Appointment+
                " Department "+Department+
                " set_of_properties_and_ratings "+set_of_properties_and_ratings;
    }
}

