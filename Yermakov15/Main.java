package ua.oop.khpi.Yermakov15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;




public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        My_List<HumanResourcesDepartment> obj = new My_List<HumanResourcesDepartment>();
        LinkedHashMap<String, Integer> characteristic = new LinkedHashMap<String, Integer>();
        characteristic.put("�������������", 5 );
        LinkedHashMap<String, String> passport_data = new LinkedHashMap<String, String>();
        passport_data.put("Name "," "+"������");
        passport_data.put("Surname "," "+"��������");
        passport_data.put("Family "," "+"���������");
        passport_data.put("Pasport ID "," "+"0000000");
        passport_data.put("Passport series"," "+"00");
        LinkedHashMap<String, String> career = new LinkedHashMap<String, String>();
        career.put("Date of appointment "," "+"22.03.2020");
        career.put("Position "," "+"��������");
        career.put("Department "," "+"����������");
        obj.add_elements(new HumanResourcesDepartment(passport_data,"������",2500, career,characteristic));

        String command = "";
        String str = "";
        do
        {


            System.out.println("������� �������\r\n" +
                    "1 - ��������� �� �����  							   \r\n" +
                    "2 - ��������� ������ �������� �� ������               \r\n" +
                    "3 - ��������� �������� �� �������					   \r\n" +
                    "4 - ����������								       \r\n" +
                    "5 - ������������ 								   \r\n" +
                    "6 - �������� �� �������� �������� � ������ 	       \r\n" +
                    "0 - ���������� ��������(�������� ������� �����������) \r\n" +
                    "");
            System.out.println("������ �������: ");
            Scanner scan = new Scanner(System.in);
            command = scan.nextLine();
            switch (command) {
                case "1": {
                    System.out.println(obj.toString());
                    break;
                }
                case "2": {

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
                    passport_data.put("Name "," "+name);
                    passport_data.put("Surname "," "+surname);
                    passport_data.put("Family "," "+family);
                    passport_data.put("Pasport ID "," "+id_passport);
                    passport_data.put("Passport series"," "+passport_series);

                    career = new LinkedHashMap<String, String>();
                    career.put("Date of appointment "," "+date_of_appointment);
                    career.put("Position "," "+position);
                    career.put("Department "," "+department);

                    HumanResourcesDepartment new_el = new HumanResourcesDepartment(passport_data,education,salary, career,characteristic);
                    obj.add_elements(new_el);
                    System.out.println("������");
                    break;
                }
                case "3": {
                    System.out.println("������ ����� �������� ��� ���������");
                    int number = scan.nextInt();
                    obj.delete(number-1);
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
                    if(!obj.null_or_not())
                        System.out.println("������ �� � ��� ��'����, ��� �� ��������� �������������� ������� 1");
                    else
                        System.out.println("������ ������, ��� ��������� �������� �������������� ������� 2");
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
