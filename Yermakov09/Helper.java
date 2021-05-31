package ua.oop.khpi.Yermakov09;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Helper {
    private static final int namePosition=0;//Имя сотрудника
    private static final int id_passPosition=1;//id паспорта
    private static final int educationPosition=2;//Образование
    private static final int Date_of_appointmentPosition=3;//Дата назначение
    private static final int AppointmentPosition=4;//Назначение
    private static final int  DepartmentPosition=5;//Отдел


    public static void serialize(Container<Employee_card>employee_cards,String filename) throws IOException {
        StringBuffer stringBuffer=new StringBuffer();

        for(Employee_card ec:employee_cards)
        {
            stringBuffer.append(ec.name);
            stringBuffer.append(",");
            stringBuffer.append(ec.id_pass);
            stringBuffer.append(",");
            stringBuffer.append(ec.education);
            stringBuffer.append(",");
            stringBuffer.append(ec.Date_of_appointment);
            stringBuffer.append(",");
            stringBuffer.append(ec.Appointment);
            stringBuffer.append(",");
            stringBuffer.append(ec.Department);
            stringBuffer.append(",");
            stringBuffer.append(ec.set_of_properties_and_ratings);

        }

        File file = new File(filename);
        if(!file.exists())
        {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(stringBuffer.toString());
        writer.close();
    }
    public static Container<Employee_card>Deserialize(String filename) throws IOException
    {
        Container<Employee_card>list=new Container<Employee_card>();
        String[] lines = new String(Files.readAllBytes(Paths.get(filename))).split("\\r?\\n");
        for (String line : lines)
        {
            String[] rows = line.split(",");
            Employee_card employee_card=new Employee_card();
            employee_card.name=rows[namePosition];
            employee_card.id_pass=Integer.parseInt(rows[id_passPosition]);
            employee_card.education=rows[educationPosition];
            employee_card.Date_of_appointment=rows[Date_of_appointmentPosition];
            employee_card.Appointment=rows[AppointmentPosition];
            employee_card.Department=rows[DepartmentPosition];
            list.add(employee_card);
        }
        return list;
    }
}
