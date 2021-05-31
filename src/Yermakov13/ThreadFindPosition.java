package ua.oop.khpi.Yermakov13;

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
        try {
            for (HumanResourcesDepartment humanresorcesdepartament : list) {
                if(!isInterrupted()) {
                    if(humanresorcesdepartament.getPosition().equals(parsing)) {
                        count++;
                    }
                } else {
                    throw new InterruptedException();

                }

            }
        }catch(InterruptedException e) {
            System.out.println("���������� ��� ���������� ������");
        }

        System.out.println("ʳ������ ���������� � ������� " + parsing + " " + count + " ��.");

    }


}