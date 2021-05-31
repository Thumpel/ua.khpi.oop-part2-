package ua.oop.khpi.Yermakov14;

public class ThreadFindPosition extends Thread {

    My_List<HumanResourcesDepartment> list;
    String parsing;


    public ThreadFindPosition(My_List<HumanResourcesDepartment> list,String parsing){
        this.list = list;
        this.parsing = parsing;
    }

    public void run()
    {
        int count =0;

        for (HumanResourcesDepartment humanresorcesdepartament : list) {
            if(!isInterrupted()) {
                if(humanresorcesdepartament.getPosition().equals(parsing)) {
                    count++;
                }
            }



        }
        System.out.println("ʳ������ ���������� � ������� " + parsing + " " + count + " ��.");

    }
}

