package ua.oop.khpi.Yermakov14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {



    private static Pattern name_p = Pattern.compile("[�-��-�a-zA-Z/-/ ]*");
    private static Pattern surname_p = Pattern.compile("[�-��-�a-zA-Z/-/ ]*");
    private static Pattern family_p = Pattern.compile("[�-��-�a-zA-Z/-/ ]*");
    private static Pattern salary_p = Pattern.compile("[0-9]*");
    private static Pattern pasport_id_p = Pattern.compile("[0-9]{8}");
    private static Pattern pasport_ser_p = Pattern.compile("[�-��-�a-zA-Z/-/ 0-9]*");
    private static Pattern date_p = Pattern.compile("[0-9/.]*");
    private static Pattern position_p = Pattern.compile("[�-��-�a-zA-Z/-/ ]*");
    private static Pattern departament_p = Pattern.compile("[�-��-�a-zA-Z/-/ ]*");
    private static Pattern property_p = Pattern.compile("[�-��-�a-zA-Z/-/ ]*");
    private static Pattern rating_p = Pattern.compile("[0-9]*");
    private static Pattern education_p = Pattern.compile("[�-��-�a-zA-Z/-/ ]*");
    private static Pattern name_x_p = Pattern.compile("��.*�.*");
    private static Pattern pasport_ser_x_p = Pattern.compile("0�");
    private static Pattern pasport_id_x_p = Pattern.compile("[0-9]*");
    private static Matcher res;

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
            System.out.println("�� �� ������ ����� ������, ����� ���������!");
            return;
        }

        My_List<HumanResourcesDepartment> obj = new My_List<HumanResourcesDepartment>();

        if(status=="auto")
        {
            int i = 0;
            LinkedHashMap<String, String> passport_data = new LinkedHashMap<String, String>();
            LinkedHashMap<String, String> career = new LinkedHashMap<String, String>();
            LinkedHashMap<String, Integer> characteristic = new LinkedHashMap<String, Integer>();
            try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("lab11.txt"),"UTF-8")))
            {

                String str  = "";
                boolean flag = false;
                String delimeter = "\\,";
                while((str = br.readLine()) != null)
                {
                    String[] strS = str.split(delimeter);

                    res = name_p.matcher(strS[0]);
                    if(res.matches())
                    {
                        flag = true;
                    }
                    else
                    {
                        flag = false;
                    }
                    res = surname_p.matcher(strS[1]);
                    if(res.matches() && flag == true)
                    {
                        flag = true;
                    }
                    else
                    {
                        flag = false;
                    }
                    res = family_p.matcher(strS[2]);
                    if(res.matches() && flag == true)
                    {
                        flag = true;
                    }
                    else
                    {
                        flag = false;
                    }
                    res = education_p.matcher(strS[3]);
                    if(res.matches() && flag == true)
                    {
                        flag = true;
                    }
                    else
                    {
                        flag = false;
                    }
                    res = salary_p.matcher(strS[4]);
                    if(res.matches() && flag == true)
                    {
                        flag = true;
                    }
                    else
                    {
                        flag = false;
                    }
                    res = pasport_id_p.matcher(strS[5]);
                    if(res.matches() && flag == true)
                    {
                        flag = true;
                    }
                    else
                    {
                        flag = false;
                    }
                    res = pasport_ser_p.matcher(strS[6]);
                    if(res.matches() && flag == true)
                    {
                        flag = true;
                    }
                    else
                    {
                        flag = false;
                    }
                    res = date_p.matcher(strS[7]);
                    if(res.matches() && flag == true)
                    {
                        flag = true;
                    }
                    else
                    {
                        flag = false;
                    }
                    res = position_p.matcher(strS[8]);
                    if(res.matches() && flag == true)
                    {
                        flag = true;
                    }
                    else
                    {
                        flag = false;
                    }
                    res = departament_p.matcher(strS[9]);
                    if(res.matches() && flag == true)
                    {
                        flag = true;
                    }
                    else
                    {
                        flag = false;
                    }
                    res = property_p.matcher(strS[10]);
                    if(res.matches() && flag == true)
                    {
                        flag = true;
                    }
                    else
                    {
                        flag = false;
                    }
                    res = rating_p.matcher(strS[11]);
                    if(res.matches() && flag == true)
                    {
                        flag = true;
                    }
                    else
                    {
                        flag = false;
                    }

                    if(flag)
                    {
                        passport_data = new LinkedHashMap<String, String>();
                        passport_data.put("Name ",strS[0]);
                        passport_data.put("Surname ",strS[1]);
                        passport_data.put("Family ",strS[2]);
                        passport_data.put("Passport ID ",strS[5]);
                        passport_data.put("Passport series ",strS[6]);
                        String education = strS[3];
                        int salary = Integer.valueOf(strS[4]);
                        career = new LinkedHashMap<String, String>();
                        career.put("Date of appointment ",strS[7]);
                        career.put("Position ",strS[8]);
                        career.put("Department ",strS[9]);
                        characteristic = new LinkedHashMap<String, Integer>();

                        HumanResourcesDepartment new_el = new HumanResourcesDepartment(passport_data,education,salary, career,characteristic);
                        obj.add_elements(new_el);
                    }
                    else
                    {
                        System.out.println("��� ����� � ���� �� ����� ����, �� �� ���������� "
                                + i );
                    }
                    i++;
                }
            }catch (Exception e) {
                System.out.println("�� ���� �� ������� ������� ����, ���� ��'��� ����������� ������������ �������");

                characteristic = new LinkedHashMap<String, Integer>();
                characteristic.put("�������������", 5 );
                passport_data = new LinkedHashMap<String, String>();
                passport_data.put("Name ","������");
                passport_data.put("Surname ","��������");
                passport_data.put("Family ","���������");
                passport_data.put("Passport ID ","22222222");
                passport_data.put("Passport series","00");
                career = new LinkedHashMap<String, String>();
                career.put("Date of appointment ","22.03.2020");
                career.put("Position ","��������");
                career.put("Department ","����������");
                obj.add_elements(new HumanResourcesDepartment(passport_data,"������",2500, career,characteristic));

                characteristic = new LinkedHashMap<String, Integer>();
                characteristic.put("�������������", 5 );
                passport_data = new LinkedHashMap<String, String>();
                passport_data.put("Name ","�����");
                passport_data.put("Surname ","�������");
                passport_data.put("Family ","�������");
                passport_data.put("Passport ID ","1111111111");
                passport_data.put("Passport series","00");
                career = new LinkedHashMap<String, String>();
                career.put("Date of appointment ","03.03.2019");
                career.put("Position ","�������");
                career.put("Department ","�������� ��");
                obj.add_elements(new HumanResourcesDepartment(passport_data,"������",2500, career,characteristic));

            }

        }


        ThreadFindPosition thr_1 = null;
        ThreadFindPosition thr_2 = null;
        ThreadFindPosition thr_3 = null;
        ThreadFindPosition thr_p = null;
        String[] commands = {"0","1","8"};
        String[] commands_sort = {"3","2","1"};
        int size = 3;
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
                        "8 - ������������ ��������                            \r\n" +
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
                    LinkedHashMap<String, Integer> characteristic;
                    LinkedHashMap<String, String> passport_data;
                    LinkedHashMap<String, String> career;
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
                        passport_data.put("Surnamew ",surname);
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
                        characteristic.put("�������������", 5 );
                        passport_data = new LinkedHashMap<String, String>();
                        passport_data.put("Name ","������");
                        passport_data.put("Surname ","��������");
                        passport_data.put("Family ","���������");
                        passport_data.put("Passport ID ","123123123");
                        passport_data.put("Passport series ","00");
                        career = new LinkedHashMap<String, String>();
                        career.put("Date of appointment ","22.03.2020");
                        career.put("Position ","��������");
                        career.put("Department ","����������");
                        obj.add_elements(new HumanResourcesDepartment(passport_data,"������",2500, career,characteristic));
                    }
                    System.out.println("������");

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
                            Helper.sort(obj, ua.oop.khpi.Yermakov14.Helper.ESort.PASSPORT_ID);
                            break;
                        }
                        case "2": {
                            Helper.sort(obj, ua.oop.khpi.Yermakov14.Helper.ESort.PASSPORT_SERIES);
                            break;
                        }
                        case "3": {
                            Helper.sort(obj, ua.oop.khpi.Yermakov14.Helper.ESort.SALARY);
                            break;
                        }
                        case "4": {
                            Helper.sort(obj, ua.oop.khpi.Yermakov14.Helper.ESort.RATING);
                            break;
                        }
                        default:
                            System.out.println("�� ���������� ��������");
                            break;
                    }

                    System.out.println("���������� ������ ���������");
                    break;
                }
                case "8":
                {
                    String name;
                    String ser_pasport;
                    String id_pasport;
                    for (HumanResourcesDepartment el : obj) {
                        name = el.getName();
                        res = name_x_p.matcher(name);
                        if(res.matches())
                        {
                            ser_pasport = el.getPassport_series();
                            res = pasport_ser_x_p.matcher(ser_pasport);
                            if(res.matches())
                            {
                                id_pasport = el.getPassport_ID();
                                res = pasport_id_x_p.matcher(id_pasport);
                                if(res.matches())
                                {
                                    System.out.println("������ ��� "+ el +" ��� ������ ����������� ������� ����������");
                                }
                            }
                        }

                    }
                    break;
                }
                case "9": {

                    System.out.println("������ ����������� ����������");
                    long time_finish_parallel;
                    long time_finish_consistently;
                    long time_start = System.nanoTime();
                    thr_1 = new ThreadFindPosition(obj,"�������");
                    thr_1.start();
                    thr_2 = new ThreadFindPosition(obj,"���������");
                    thr_2.start();
                    thr_3 = new ThreadFindPosition(obj,"��������");
                    thr_3.start();
                    time_finish_parallel = System.nanoTime();
                    time_finish_parallel -= time_start;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("ʳ���� ����������� ���������\n");
                    time_start = 0;
                    System.out.println("������ ���������� ����������");
                    time_start = System.nanoTime();
                    thr_p = new ThreadFindPosition(obj,"�������");
                    thr_p.start();
                    thr_p = new ThreadFindPosition(obj,"���������");
                    thr_p.start();
                    thr_p = new ThreadFindPosition(obj,"��������");
                    thr_p.start();
                    time_finish_consistently = System.nanoTime();
                    time_finish_consistently -= time_start;
                    System.out.println("ʳ���� ���������� ���������\n");
//
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(""
                            + "===================================="
                            +"\n||����������� ���||���������� ���||\n"
                            + "====================================\n"
                            + "|| "+ time_finish_parallel +"    || "+ time_finish_consistently+"       ||\n"
                            + "====================================\n"
                            + "г����� = " + (float)((float)time_finish_parallel/(float)time_finish_consistently) );


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
