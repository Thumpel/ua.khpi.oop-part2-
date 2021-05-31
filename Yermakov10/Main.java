package ua.oop.khpi.Yermakov10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String status = "";
        if(args.length>0)
        {
            if(args[0].equals("-auto")||args[0].equals("-a"))
                status = "auto";
            if (args[0].equals("-dialog")||args[0].equals("-d"))
                status = "dialog";
        }
        else
        {
            System.out.println("Неправильный запуск программы");
            return;
        }

        My_List<HumanResourcesDepartment> obj;
        LinkedHashMap<String, Integer> characteristic;
        LinkedHashMap<String, String> passport_data;
        LinkedHashMap<String, String> career;

        if(status=="auto")
        {
            obj = new My_List<HumanResourcesDepartment>();
            characteristic = new LinkedHashMap<String, Integer>();
            characteristic.put("Характеристика", 5 );
            passport_data = new LinkedHashMap<String, String>();
            passport_data.put("Name ","Дмитрий");
            passport_data.put("Surname ","Ермаков");
            passport_data.put("Family ","Сергеевич");
            passport_data.put("Passport ID ","1488228");
            passport_data.put("Passport series","00");
            career = new LinkedHashMap<String, String>();
            career.put("Date of appointment ","22.03.2020");
            career.put("Position ","Разработчик");
            career.put("Department ","Игровое");
            obj.add_elements(new HumanResourcesDepartment(passport_data,"Высшее",10000, career,characteristic));

            characteristic = new LinkedHashMap<String, Integer>();
            characteristic.put("Характеристика", 5 );
            passport_data = new LinkedHashMap<String, String>();
            passport_data.put("Name ","Сергей");
            passport_data.put("Surname ","Левшня");
            passport_data.put("Family ","Сергеевич");
            passport_data.put("Passport ID ","3220228");
            passport_data.put("Passport series","01");
            career = new LinkedHashMap<String, String>();
            career.put("Date of appointment ","03.03.2019");
            career.put("Position ","Веб-программист");
            career.put("Department ","Разработка сайтов");
            obj.add_elements(new HumanResourcesDepartment(passport_data,"высшее",10000, career,characteristic));

        }
        else
        {
            obj = new My_List<ua.oop.khpi.Yermakov10.HumanResourcesDepartment>();
        }


        String[] commands = {"0","1","7","1","3","1","2","1","6"};
        String[] commands_sort = {"3","2","1"};
        int size = 9;
        int size_sort = 2;
        String command = "";
        do
        {
            Scanner scan = new Scanner(System.in);
            if(status=="dialog")
            {
                System.out.println("������� �������\r\n" +
                        "1 - ��������� �� �����  							   \r\n" +
                        "2 - ��������� ������ �������� �� ������               \r\n" +
                        "3 - ��������� �������� �� �������					   \r\n" +
                        "4 - ����������								       \r\n" +
                        "5 - ������������ 								   \r\n" +
                        "6 - �������� �� �������� �������� � ������ 	       \r\n" +
                        "7 - ���������� 							 	       \r\n" +
                        "0 - ���������� ��������(�������� ������� �����������) \r\n" +
                        "");
                System.out.println("������ �������: ");

                command = scan.nextLine();
            }
            else
            {
                if(size!=0)
                {
                    command = commands[size-1];
                    size--;
                }
                else
                {
                    System.out.println("������ ��� ��������� ����� ����, ����� ���������");
                    obj.cls();
                    return;
                }

            }

            switch (command) {
                case "1": {
                    System.out.println(obj.toString());
                    break;
                }
                case "2": {
                    if(status == "dialog")
                    {
                        Scanner scan_int = new Scanner(System.in);
                        Scanner scan_str = new Scanner(System.in);
                        System.out.println("������� ��� ���������� ");
                        String name = scan_str.nextLine();
                        System.out.println("������� ������� ���������� ");
                        String surname = scan_str.nextLine();
                        System.out.println("������� ��������� ���������� ");
                        String family = scan_str.nextLine();
                        System.out.println("������� ����� �������� ");
                        String id_passport= scan_str.nextLine();
                        System.out.println("������� ����� �������� ");
                        String passport_series = scan_str.nextLine();

                        System.out.println("������� ���������� �� �����������");
                        String education = scan_str.nextLine();

                        System.out.println("������� ���� ������ �� ������");
                        String date_of_appointment = scan_str.nextLine();
                        System.out.println("������� ��������� ");
                        String position = scan_str.nextLine();
                        System.out.println("������� ���������");
                        String department = scan_str.nextLine();

                        characteristic = new LinkedHashMap<String, Integer>();
                        System.out.println("������� ���������� �������");
                        int size1 = scan_int.nextInt();

                        while(size1 != 0)
                        {
                            System.out.println("������� �������� ��������������");
                            String property = scan_str.nextLine();

                            System.out.println("������� ������ ������� ��������");
                            int rating = scan_int.nextInt();

                            characteristic.put(property, rating);
                            size1--;
                        }

                        System.out.println("������� ���������� ��� ���������");
                        int salary = scan_int.nextInt();

                        passport_data = new LinkedHashMap<String, String>();
                        passport_data.put("Name ",name);
                        passport_data.put("Surname ",surname);
                        passport_data.put("Family ",family);
                        passport_data.put("Passport ID ",id_passport);
                        passport_data.put("Passport series",passport_series);

                        career = new LinkedHashMap<String, String>();
                        career.put("Date of appointment ",date_of_appointment);
                        career.put("Position ",position);
                        career.put("Department ",department);

                        HumanResourcesDepartment new_el = new HumanResourcesDepartment(passport_data,education,salary, career,characteristic);
                        obj.add_elements(new_el);
                        System.out.println("������");
                        break;
                    }
                    else
                    {
                        characteristic = new LinkedHashMap<String, Integer>();
                        characteristic.put("Характеристика", 5 );
                        passport_data = new LinkedHashMap<String, String>();
                        passport_data.put("Name ","Нихад");
                        passport_data.put("Surname ","Сафарли");
                        passport_data.put("Family ","Оглы");
                        passport_data.put("Passport ID ","228322");
                        passport_data.put("Passport series ","03");
                        career = new LinkedHashMap<String, String>();
                        career.put("Date of appointment ","22.03.2020");
                        career.put("Position ","Джава разработчик");
                        career.put("Department ","Программирвоание");
                        obj.add_elements(new HumanResourcesDepartment(passport_data,"Высшее",1000, career,characteristic));
                    }

                    break;
                }
                case "3": {

                    if(status == "dialog")
                    {
                        System.out.println("������ ����� �������� ��� ���������");
                        int number = scan.nextInt();
                        obj.delete(number-1);

                    }
                    else
                    {
                        obj.delete(1);
                    }
                    System.out.println("������");
                    break;
                }
                case "4": {
                    FileOutputStream fs = new FileOutputStream("Serial.ser");
                    ObjectOutputStream os = new ObjectOutputStream(fs);
                    os.writeObject(obj);
                    os.close();
                    System.out.println("���������� ���������");
                    break;
                }
                case "5": {
                    FileInputStream fis = new FileInputStream("Serial.ser");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    My_List var = (My_List) ois.readObject();
                    obj = var;
                    ois.close();
                    System.out.println("������������ ���������");
                    break;
                }
                case "6": {
                    if(obj.null_or_not())
                        System.out.println("������ �� � ��� ��'����, ��� �� ��������� �������������� ������� 1");
                    else
                        System.out.println("������ ������, ��� ��������� �������� �������������� ������� 2");
                    break;
                }
                case "7":  {
                    System.out.println("����������");
                    String com = "";
                    if(status == "dialog")
                    {
                        System.out.println("������ ������ ����������"
                                + "\n 1 - �� ������� �������� "
                                + "\n 2 - �� ���� ��������"
                                + "\n 3 - �� �������"
                                + "\n 4 - �� ���������");
                        com = scan.nextLine();
                    }
                    else
                    {
                        if(size!=0)
                        {
                            com = commands_sort[size_sort];
                            size_sort--;
                        }
                        else
                        {
                            System.out.println("������ ��� ���������� ����, ���������� ����������");
                            break;
                        }
                    }
                    switch (com) {
                        case "1": {
                            Helper.sort(obj, ua.oop.khpi.Yermakov10.Helper.ESort.PASSPORT_ID);
                            break;
                        }
                        case "2": {
                            Helper.sort(obj, ua.oop.khpi.Yermakov10.Helper.ESort.PASSPORT_SERIES);
                            break;
                        }
                        case "3": {
                            Helper.sort(obj, ua.oop.khpi.Yermakov10.Helper.ESort.SALARY);
                            break;
                        }
                        case "4": {
                            Helper.sort(obj, ua.oop.khpi.Yermakov10.Helper.ESort.RATING);
                            break;
                        }
                        default:
                            System.out.println("�� ���������� ��������");
                            break;
                    }

                    System.out.println("���������� ������ ���������");
                    break;
                }
                case "0": {
                    System.out.println("ʳ���� ��������");
                    obj.cls();
                    break;
                }
                default:
                    System.out.println("�� ���������� ��������");
                    break;
            }

        }while(!(command.equals("0")));
    }


}


