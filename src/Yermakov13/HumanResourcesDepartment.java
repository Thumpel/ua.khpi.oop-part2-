package ua.oop.khpi.Yermakov13;

import java.util.LinkedHashMap;
import java.util.Set;

public class HumanResourcesDepartment {

    private LinkedHashMap<String, String> passport_data;
    private String education;
    private int salary;
    private LinkedHashMap<String, String> career;
    private LinkedHashMap<String, Integer> characteristic;



    public LinkedHashMap<String, String> getPassport_data() {
        return passport_data;
    }
    public void setPassport_data(LinkedHashMap<String, String> passport_data) {
        this.passport_data = passport_data;
    }
    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public LinkedHashMap<String, String> getCareer() {
        return career;
    }
    public void setCareer(LinkedHashMap<String, String> career) {
        this.career = career;
    }
    public LinkedHashMap<String, Integer> getCharacteristic() {
        return characteristic;
    }
    public void setCharacteristic(LinkedHashMap<String, Integer> characteristic) {
        this.characteristic = characteristic;
    }

    public String getName()
    {
        return new String(passport_data.get("Name "));
    }
    public String getSurname()
    {
        return new String(passport_data.get("Surname "));
    }
    public String getFamily()
    {
        return new String(passport_data.get("Family "));
    }
    public String getPassport_ID()
    {
        return new String(passport_data.get("Passport ID "));
    }
    public String getPassport_series()
    {
        return new String(passport_data.get("Passport series "));
    }

    public String getDateOfAppointment()
    {
        return new String(career.get("Date of appointment "));
    }
    public String getPosition()
    {
        return new String(career.get("Position "));
    }
    public String getDepartment()
    {
        return new String(career.get("Department "));
    }

    public void setDateOfAppointment(String el)
    {
        career.put("Date of appointment ", el);
    }
    public void setPosition(String el)
    {
        career.put("Position ", el);
    }
    public void  setDepartment(String el)
    {
        career.put("Department ",el);
    }


    public String getAverage_ratting()
    {
        float avg=0f;
        Set set = characteristic.keySet();
        for (Object object : set) {
            avg += characteristic.get(object);
        }
        float res = avg/characteristic.size();
        return Float.toString(res);
    }

    public HumanResourcesDepartment() {
        super();
        // TODO Auto-generated constructor stub
    }
    public HumanResourcesDepartment(LinkedHashMap<String, String> passport_data, String education, int salary,
                                    LinkedHashMap<String, String> career, LinkedHashMap<String, Integer> characteristic) {
        super();
        this.passport_data = passport_data;
        this.education = education;
        this.salary = salary;
        this.career = career;
        this.characteristic = characteristic;
    }



    public String passport_dataTo_string() {

        String string ="";
        Set set = passport_data.entrySet();
        for (Object el: set) {
            string+=el.toString();
            string+="\n";
        }
        return string;
    }

    public String careerTo_string() {

        String string ="";
        Set set = career.entrySet();
        for (Object el: set) {
            string+=el.toString();
            string+="\n";
        }
        return string;
    }

    public String characteristicTo_string() {

        String string ="";
        Set set = characteristic.entrySet();
        for (Object el: set) {
            string+=el.toString();
            string+="\n";
        }
        return string;
    }

    public void Show()
    {
        System.out.println("���������� ������ - \n"+ passport_dataTo_string()  +"\r" +
                "����������� - "+ education + "\r\n" +
                "����� - " + salary  +"\r\n"+
                "�������  " + careerTo_string()  +"\r"+
                "�������������� "+ characteristicTo_string()  + "\r\n");

    }

    public String toString()
    {
        return "���������� ������ - \n"+ passport_dataTo_string()  +"\r" +
                "����������� - "+ education + "\r\n" +
                "����� - " + salary  +"\r\n"+
                "�������  " + careerTo_string()  +"\r"+
                "�������������� "+ characteristicTo_string()  + "\r\n";
    }

}
